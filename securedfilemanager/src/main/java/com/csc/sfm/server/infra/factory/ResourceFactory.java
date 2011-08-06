package com.csc.sfm.server.infra.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.File;
import com.csc.sfm.server.domain.FileExtension;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceAccessibility;
import com.csc.sfm.server.domain.ResourceType;

public class ResourceFactory {

  /*
   * PUBLIC
   */
  
  public static Directory newParentInstance(Integer parentId) {
    Directory parent = new Directory();
    
    initializeInstance(parent, parentId, "..", ResourceAccessibility.OPEN, null, null, null);
    parent.setType(ResourceType.PARENT);
    
    parent.setChildren(new ArrayList<Resource>());
    
    return parent;
  }
	
  public static Directory newDirectoryInstance() {
    Directory directory = new Directory();
    
    Date creationDate = GregorianCalendar.getInstance().getTime();
    
    initializeInstance(directory, null, "", ResourceAccessibility.OPEN, null, creationDate, creationDate);
    
    directory.setChildren(new ArrayList<Resource>());
    
    return directory;
  }
  
  public static File newFileInstance() {
    File file = new File();
    
    Date creationDate = GregorianCalendar.getInstance().getTime();
    
    initializeInstance(file, null, "", ResourceAccessibility.OPEN, null, creationDate, creationDate);
    
    file.setExtension(FileExtension.OTHER);
    file.setSize(0);
    
    return file;
  }
  
  private static void initializeInstance(Resource resource, Integer id, String name, ResourceAccessibility accesibility, Resource parent, Date creationDate, Date modificationDate) {
    resource.setId(id);
    resource.setName(name);
    resource.setAccessibility(accesibility);
    resource.setParent(parent);
    resource.setCreationDate(creationDate);
    resource.setModificationDate(modificationDate);
  }
  

}
