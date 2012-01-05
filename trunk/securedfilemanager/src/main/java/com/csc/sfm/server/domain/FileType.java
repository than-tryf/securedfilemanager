package com.csc.sfm.server.domain;

public enum FileType {

	DWG("application/acad", "bin"),
	BIN("application/octet-stream", "bin"),
	PDF("application/pdf", "pdf"), 
	RTF("application/rtf", "rtf"),
	TAR("application/x-tar", "tar"), 
	JPG("application/jpeg", "jpg"),
	JPEG("application/jpeg", "jpeg"),
	JPE("application/jpe", "jpe"),
	JS("application/javascript", "js"),
	MP4("application/mp4", "mp4"),
	DOC("application/msword", "doc"),
	DOCX("application/msword", "docx"),
	XML("application/xml", "xml"),
	ZIP("multipart/x-zip", "zip"),
	GZ("multipart/x-gzip", "gz"),
	GZIP("multipart/x-gzip", "gzip"),
	HTML("text/html", "html"),
	HTM("text/html", "htm"),
	TXT("text/plain", "txt"),
	H("text/plain", "h"),
	C("text/plain", "c"),
	G("text/plain", "g"),
	CSS("text/css", "css"),
	RTX("text/richtext", "RTX"),
	PNG("image/png", "png"),
	BMP("image/bmp", "bmp"),
	GIF("images/gif", "gif"),
	MP3("audio/mp3", "mp3"),
	WAV("audio/x-wav", "wav"),
	MPEG("video/mpeg", "mpeg"),
	MPG("video/mpeg", "mpg"),
	MPE("video/mpeg", "mpe"),
	AVI("video/msvideo", "avi"),
	MOVIE("video/x-sgi-movie", "movie");
		
	private final String mimeType;
	
	private final String extension;
	
	private FileType(String mimeType, String extension) {
		this.mimeType = mimeType;
		this.extension = extension;
	}

  public String getMimeType() {
    return mimeType;
  }

  public String getExtension() {
    return extension;
  }

}
