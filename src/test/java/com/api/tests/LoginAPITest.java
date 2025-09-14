package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.authService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Verify if login api is working")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("qaiserhabib", "Qaiserhabib@123");
		authService auth = new authService();
		Response response = auth.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "qaiserhabib105@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 2768);
	}
}
