package com.csc.sfm.server.infra.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.csc.sfm.server.domain.Directory;
import com.csc.sfm.server.domain.File;
import com.csc.sfm.server.domain.FileExtension;
import com.csc.sfm.server.domain.Resource;
import com.csc.sfm.server.domain.ResourceAccessibility;

public class ResourceFactory {

  /*
   * PUBLIC
   */
  
  public Directory newDirectoryInstance() {
    Directory directory = new Directory();
    
    Date creationDate = GregorianCalendar.getInstance().getTime();
    
    initializeInstance(directory, null, "", ResourceAccessibility.OPEN, null, creationDate, creationDate);
    
    directory.setChildren(new ArrayList<Resource>());
    
    return directory;
  }
  
  public File newFileInstance() {
    File file = new File();
    
    Date creationDate = GregorianCalendar.getInstance().getTime();
    
    initializeInstance(file, null, "", ResourceAccessibility.OPEN, null, creationDate, creationDate);
    
    file.setExtension(FileExtension.OTHER);
    file.setSize(0);
    
    return file;
  }
  
  private void initializeInstance(Resource resource, Integer id, String name, ResourceAccessibility accesibility, Resource parent, Date creationDate, Date modificationDate) {
    resource.setId(id);
    resource.setName(name);
    resource.setAccessibility(accesibility);
    resource.setParent(parent);
    resource.setCreationDate(creationDate);
    resource.setModificationDate(modificationDate);
  }
  

}
