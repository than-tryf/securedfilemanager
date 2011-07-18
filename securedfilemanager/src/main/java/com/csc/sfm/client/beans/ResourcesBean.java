package com.csc.sfm.client.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.csc.sfm.server.domain.ResourceAccessibility;
import com.csc.sfm.server.domain.ResourceType;
import com.csc.sfm.shared.vo.ResourceVO;

@ManagedBean
@SessionScoped
public class ResourcesBean {

	public List<ResourceVO> getResources() {
		List<ResourceVO> resources = new ArrayList<ResourceVO>();
		
		ResourceVO dirSpring = new ResourceVO("Spring", ResourceType.DIRECTORY, "Spring", ResourceAccessibility.OPEN, null, null, 0);
		resources.add(dirSpring);
		
		ResourceVO dirJsf = new ResourceVO("JSF", ResourceType.DIRECTORY, "JSF", ResourceAccessibility.OPEN, null, null, 0);
		resources.add(dirJsf);
				
		ResourceVO fileTotoXml = new ResourceVO("Toto.xml", ResourceType.FILE, "Toto.xml", ResourceAccessibility.OPEN,  null, null, 102);
		resources.add(fileTotoXml);

		ResourceVO fileTataTxt = new ResourceVO("Tata.txt", ResourceType.FILE, "Tata.xml", ResourceAccessibility.OPEN, null, null, 13);
		resources.add(fileTataTxt);
		
		return resources;
	}

}
