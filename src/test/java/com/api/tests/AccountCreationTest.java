package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.authService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify if signup api is working")
	public void createAccountTest() {
		SignUpRequest signUpRequest= new SignUpRequest.Builder()
		.userName("akbar12")
		.email("akbar12@yopmail.com")
		.firstName("Akbar12")
		.lastName("Ali12")
		.password("Akbar!12312")
		.mobileNumber("2267847486")
		.build();
		
		authService auth = new authService();
		Response response = auth.Signup(signUpRequest);
//		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
}
