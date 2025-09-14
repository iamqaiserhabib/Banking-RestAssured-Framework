package com.api.base;

import java.util.HashMap;

import com.api.models.requests.LoginRequest;

import io.restassured.response.Response;

public class authService extends baseService {

	private static final String BASE_PATH = "/api/auth/";
	
	public Response login(Object payload) {
		return postRequest(payload, BASE_PATH +"login");
	}
	
	public Response Signup(Object payload) {
		return postRequest(payload, BASE_PATH +"signup");
	}
	
	public Response forgotPassword(String emailAddress) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", emailAddress);
		return postRequest(payload, BASE_PATH +"forgot-password");
	}
}
