package com.csc.sfm.infra.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UrlParserTest {

  /*
   * CleanUrl ----------------------------------------------------------------
   */
  @Test
  public void cleanUrl_withEmptyUrl_isOk() {
    assert_cleanUrl("", "");
  }

  @Test
  public void cleanUrl_withRootUrl_isOk() {
    assert_cleanUrl("/", "");
  }

  @Test
  public void cleanUrl_withCleanUrl_isOk() {
    assert_cleanUrl("public/blog", "public/blog");
  }

  @Test
  public void cleanUrl_withOpeningSlash_isOk() {
    assert_cleanUrl("/public/blog", "public/blog");
  }
  
  @Test
  public void cleanUrl_withclosingSlash_isOk() {
    assert_cleanUrl("public/blog/", "public/blog");
  }

  @Test
  public void cleanUrl_withOpeningAndClosingSlashes_isOk() {
    assert_cleanUrl("/public/blog/", "public/blog");
  }

  @Test
  public void cleanUrl_withDirtyUrl_isOk() {
    assert_cleanUrl("/////public////blog///////", "public/blog");
  }

  /*
   * -------------------------------------------------------------------------
   */

  /*
   * getNextDomainFromBeginning
   */

  @Test
  public void getNextDomainFromBeginning_withEmptyUrl_isOk() {
    assert_getNextDomainFromBeginning("", "");
  }
  
  @Test
  public void getNextDomainFromBeginning_withRootUrl_isOk() {
    assert_getNextDomainFromBeginning("/", "");
  }

  @Test
  public void getNextDomainFromBeginning_withRootChildUrl_isOk() {
    assert_getNextDomainFromBeginning("public/blog", "public");
  }

  /*
   * -------------------------------------------------------------------------
   */

  /*
   * getRemainingUrl
   */

  @Test
  public void getRemainingUrl_withEmptyUrl_isOk() {
    assert_getRemainingUrl("", "");
  }
  
  @Test
  public void getRemainingUrl_withRootUrl_isOk() {
    assert_getRemainingUrl("/", "");
  }

  @Test
  public void getRemainingUrl_withRootChildUrl_isOk() {
    assert_getRemainingUrl("public", "");
  }

  @Test
  public void getRemainingUrl_withCommonUrl_isOk() {
    assert_getRemainingUrl("public/works/spring", "works/spring");
  }
  
  /*
   * PRIVATE
   */

  private void assert_cleanUrl(String url, String expected) {
    // Given
    
    // When
    String actual = UrlParser.cleanUrl(url);

    // Then
    assertTrue(expected.equals(actual));
  }
  
  private void assert_getNextDomainFromBeginning(String url, String expected) {
    // Given
    
    // When
    String actual = UrlParser.getNextDomainFromBeginning(url);
    
    // Then
    assertTrue(expected.equals(actual));
  }
  
  private void assert_getRemainingUrl(String url, String expected) {
    // Given
    
    // When
    String actual = UrlParser.getRemaininUrl(url);
    
    // Then
    assertTrue(expected.equals(actual));
  }
  
}
