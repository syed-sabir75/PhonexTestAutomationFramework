package com.api.tests;

import org.testng.annotations.Test;
import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.services.UserService;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
@Epic("User Management")
@Feature("User Details")
@Listeners(com.listeners.APITestListener.class)
public class UserDetailsAPITest {

	private UserService userService;
    
	@BeforeMethod(description = "Setting up the UserService instance")
	public void setup() {
		userService = new UserService();

	}
    @Story("UserDetails should be shown")
    @Description("Verify if the Userdetails API response is shown correctly")
    @Severity(SeverityLevel.CRITICAL)
	@Test(description = "Verify if the Userdetails API response is shown correctly", groups = { "api", "smoke",
			"regression" })
	public void userDetailsAPITest() throws IOException {

		UserService userService = new UserService();
		userService.userDeatils(FD).then().spec(responseSpec_OK()).and()
				.body(matchesJsonSchemaInClasspath("response-schema/UserDetailsResponseSchema.json"));

	}

}
