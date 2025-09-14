package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.authService;
import com.api.base.userPorfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void udpateProfileTest() {
		authService auth = new authService();
		Response response = auth.login(new LoginRequest("qaiserhabib", "Qaiserhabib@123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		userPorfileManagementService userProfile = new userPorfileManagementService();
		response = userProfile.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
//		System.out.println(userProfileResponse.getUsername());
		Assert.assertEquals(userProfileResponse.getUsername(), "qaiserhabib");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Asif")
				.lastName("Ali")
				.email("asifali@yopmail.com")
				.mobileNumber("2267847486")
				.build();
		response = userProfile.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
	}
}
