package com.api.base;

import io.restassured.response.Response;

public class userPorfileManagementService extends baseService {
	
	private static final String BASE_PATH = "/api/users";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH +"/profile");
	}
	
	public Response updateProfile(String token, Object paylaod) {
		setAuthToken(token);
		return putRequest(paylaod,BASE_PATH +"/profile");
	}
}
