package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.authService;
import com.api.base.userPorfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test
	public void getProfileInfoTest() {
		authService auth = new authService();
		Response response = auth.login(new LoginRequest("qaiserhabib", "Qaiserhabib@123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		userPorfileManagementService userProfile = new userPorfileManagementService();
		response = userProfile.getProfile(loginResponse.getToken());
//		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
	}
}
