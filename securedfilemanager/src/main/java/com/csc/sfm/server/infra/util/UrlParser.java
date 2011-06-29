package com.csc.sfm.server.infra.util;

import java.util.List;

import com.csc.sfm.server.application.exception.NotYetImplementedException;

public class UrlParser {

  public static String cleanUrl(String url) {
    if (url == null || url.trim().isEmpty()) {
      return "";
    }
    String domains[] =  url.trim().split("/");
    if (domains.length == 0) {
      return "";
    }
    String result = "";
    int i = 0;
    for (; i < domains.length - 1; i++) {
      String domain = domains[i];
      if (!domains[i].isEmpty()) {
        result += domain + "/";
      }
    }
    result += domains[i];
    return result;
  }
  
  public static String getNextDomainFromBeginning(String url) {
    if (url == null || url.trim().isEmpty()) {
      return "";
    }
    String domains[] =  url.trim().split("/");
    if (domains.length == 0) {
      return "";
    }
    return domains[0];
  }

  public static String getRemaininUrl(String url) {
    if (url == null || url.trim().isEmpty()) {
      return "";
    }
    String domains[] =  url.trim().split("/");
    if (domains.length <= 1) {
      return "";
    }
    String result = domains[1];
    int i = 2;
    for (; i < domains.length; i++) {
      String domain = domains[i];
      if (!domains[i].isEmpty()) {
        result += "/" + domain;
      }
    }
    return result;
  }

  public static List<String> getOrderedDomainsList(String url) {
    // TODO
    throw new NotYetImplementedException();
  }
  
}
