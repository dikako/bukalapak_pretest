package com.test.api.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.test.api.config.Base;
import com.test.api.config.BaseUrl;
import com.test.api.function.DataCompare;
import com.test.api.function.DataType;
import com.test.api.function.StatusCode;
import com.test.api.utility.ReadExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPosts extends Base {

  public String path = "../bukalapak_pretest_endpoint/src/test/java/com/test/api/data/data.xlsx";

  @DataProvider
  public String[][] postsData() throws InvalidFormatException, IOException {
    ReadExcel readExcel = new ReadExcel();
    return readExcel.getCellData(path, "posts");
  }

  
  @Severity(SeverityLevel.CRITICAL)
  @Description("Test Get Posts - Validate Data Type")
  @Test(priority = 0, testName = "Validate Data Type")
  public void dataType() {
    BaseUrl baseUrl = new BaseUrl();
    DataType dataType = new DataType();

    rs.baseUri(baseUrl.urls("/posts")).when().get().then().statusCode(200);

    Response response = rs.get();
    Integer id = response.getBody().path("id.size()");    
    for(int i = 0; i < id; i++) {
      int index = i;
      dataType.isInteger(response.getBody().path("userId[" + index + "]")); 
      dataType.isInteger(response.getBody().path("id[" + index + "]"));
      dataType.isString(response.getBody().path("title[" + index + "]"));
      dataType.isString(response.getBody().path("body[" + index + "]"));
    }
  }

  @Severity(SeverityLevel.CRITICAL)
  @Description("Test Post Posts - Validate Input Data == Response Body")
  @Test(priority = 1, testName = "Validate Input Data == Response Body", dataProvider = "postsData")
  public void dataInput(String title, String body, String userId) {
    BaseUrl baseUrl = new BaseUrl();
    DataCompare dataCompare = new DataCompare();
    StatusCode statusCode = new StatusCode();

    Map<String, Object> posts = new HashMap<String,Object>();
    posts.put("title", title);
    posts.put("body", body);
    posts.put("userId", userId);

    List<Map<String, Object>> toJson = new ArrayList<Map<String,Object>>();
    toJson.add(posts);

    rs.baseUri(baseUrl.urls("/posts")).contentType(ContentType.JSON).body(posts).log().all();

    statusCode.created(rs);

    dataCompare.postResponseCompare("title", rs, title);
    dataCompare.postResponseCompare("body", rs, body);
    dataCompare.postResponseCompare("userId", rs, userId);
    

  }
}