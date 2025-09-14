package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.authService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description = "Verify if forgot password api is working")
	public void forgotPasswordTest() {
		authService auth = new authService();
		Response response = auth.forgotPassword("qaiserhabib105@gmail.com");
		System.out.println(response.asPrettyString());
	}
}
