package com.csc.sfm.application.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.sfm.application.exception.ResourceForbiddenException;
import com.csc.sfm.application.exception.ResourceNotFoundException;
import com.csc.sfm.application.service.ResourceService;
import com.csc.sfm.domain.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-context.xml"})
public class ResourceServiceImplTest {

  @Autowired
  @Qualifier("resourceService")
  private ResourceService underTest;
  
  /*
   * getResource
   */
  
  @Test
  public void getResource_withWrongUrl_throwResourceNotFoundException() {
    // Given
    String url = "/Inexistant/Url";
    try {
      underTest.getResource(url);
      Assert.fail("Expected ResourceNotFoundException exception but no one was thrown");
    } catch (ResourceNotFoundException rnfe) {
      // Test succeed
    } catch (Exception e) {
      Assert.fail("Expected ResourceNotFoundException exception but another one was thrown of type " + e.getClass().getName());
    }
  }

  @Test
  public void getResource_withClosedAccessibility_throwResourceForbiddenException() {
    // Given
    String url = "/private/";
    try {
      underTest.getResource(url);
      Assert.fail("Expected ResourceForbiddenException exception but no one was thrown");
    } catch (ResourceForbiddenException rfe) {
      // Test succeed
    } catch (Exception e) {
      Assert.fail("Expected ResourceForbiddenException exception but another one was thrown of type " + e.getClass().getName());
    }
  }

  
  @Test
  public void getResource_withValidUrlForRootResource_isOk() {
    assert_getResource_withValidUrl_isOk("/");
  }

  @Test
  public void getResource_withValidUrlForRootChildResource_isOk() {
    assert_getResource_withValidUrl_isOk("/public/");
  }

  @Test
  public void getResource_withValidUrlForDeepResource_isOk() {
    assert_getResource_withValidUrl_isOk("/public/works/spring");
  }

  /*
   * PRIVATE
   */
  public void assert_getResource_withValidUrl_isOk(String url) {
    // Given
    
    try {
      // When
      Resource actual = underTest.getResource(url);
      
      // Then
      assertNotNull(actual);
    } catch (Exception e) {
      fail("Expected no exception but one was thrown of type " + e.getClass().getName());
    }
  }

}
