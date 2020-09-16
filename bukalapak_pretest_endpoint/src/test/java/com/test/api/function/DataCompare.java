package com.test.api.function;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataCompare {

  public void postResponseCompare(String path, RequestSpecification rs, String body) {
    Response res = rs.post();
    Assert.assertEquals(res.getBody().path(path), body);
    System.out.println("Response Body: " + res.getBody().path(path).toString());
  }
    
}