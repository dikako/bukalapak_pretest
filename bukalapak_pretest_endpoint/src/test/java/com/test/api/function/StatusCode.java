package com.test.api.function;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StatusCode {
    
  public void created(RequestSpecification rs) {
    Response response = rs.post();
    Assert.assertEquals(response.getStatusCode(), 201);
  }

  public void ok(RequestSpecification rs) {
    Response response = rs.post();
    Assert.assertEquals(response.getStatusCode(), 200);
  }
}