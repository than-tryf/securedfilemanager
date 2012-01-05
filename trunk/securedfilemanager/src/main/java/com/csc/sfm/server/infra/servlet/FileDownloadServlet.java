package com.csc.sfm.server.infra.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.csc.sfm.server.infra.repository.ResourceRepository;

public class FileDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	private static final String FILE_UPLOADS_FOLDER = "C:/upload/";
	
	/**
	 * Returns the requested file.
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get ID from request.
		String fileId = request.getParameter("id");

		// Check if ID is supplied to the request.
		if (fileId == null) {
			// Do your thing if the ID is not supplied to the request.
			// Throw an exception, or send 404, or show default/warning page, or just
			// ignore it.
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}

		// Retrieve the file URI from the database
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ResourceRepository resourceRepository = (ResourceRepository) context.getBean("resourceRepository");
		com.csc.sfm.server.domain.File resource = resourceRepository.getFile(Integer.parseInt(fileId));

		// Check if file is actually retrieved from database.
		if (resource == null) {
			// Do your thing if the file does not exist in database.
			// Throw an exception, or send 404, or show default/warning page, or just
			// ignore it.
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}

		// Get the physical file from its URI
		String filePath = FILE_UPLOADS_FOLDER + resource.getUri();
		File file = new File(filePath);
			
		// Init servlet response.
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(resource.getContentType());
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

		// Prepare streams.
		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {
			// Open streams.
			input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
			output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

			// Write file contents to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} finally {
			// Gently close streams.
			close(output);
			close(input);
		}
	}

	/**
	 * Close an input/output stream
	 * 
	 * @param resource
	 */
	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				// Do your thing with the exception. Print it, log it or mail it.
				e.printStackTrace();
			}
		}
	}

}
