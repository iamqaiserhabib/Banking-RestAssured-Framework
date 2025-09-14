package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest2 {

	@Test(description = "Verify if login api is working")
	public void loginTest() {
		
		Response response = given()
				.baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
	            .body(" {\"username\": \"qaiserhabib\", \"password\": \"Qaiserhabib@123\"}")
	            .post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
