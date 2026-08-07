package com.api.utils;

import static com.api.utils.ConfigManager.getProperty;

import org.hamcrest.Matchers;

import com.api.constant.Role;
import com.api.filters.SensitiveDataFilter;
import com.api.request.model.UserCredentials;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

	// GET -- DEL
	@Step("Setting up the BaseURI , Content Type as Application/JSON and attaching the SensitiveData Filter")
	public static RequestSpecification requestSpec() {
		// to take care of the common request sections (methods)
		RequestSpecification request = new RequestSpecBuilder().setBaseUri(getProperty("BASE_URI"))
				.setContentType(ContentType.JSON).setAccept(ContentType.JSON)
				.addFilter(new SensitiveDataFilter())
				.build();
		return request;
	}

	// POST-PUT-PATCH
	@Step("Setting up the BaseURI , Content Type as Application/JSON and attaching the SensitiveData Filter")
	public static RequestSpecification requestSpec(Object payload) {
		// to take care of the common request sections (methods)
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri(getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBody(payload)
				.addFilter(new SensitiveDataFilter())
				.build();
		return requestSpecification;

	}
	@Step("Setting up the BaseURI , Content Type as Application/JSON and attaching the SensitiveData Filter for a role")
	public static RequestSpecification requestSpecWithAuth(Role role) {
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri(getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.addHeader("Authorization", AuthTokenProvider.getToken(role))
				.addFilter(new SensitiveDataFilter())
				.build();
		return requestSpecification;
	}
	@Step("Setting up the BaseURI , Content Type as Application/JSON and attaching the SensitiveData Filter for a role and attaching payload")
	public static RequestSpecification requestSpecWithAuth(Role role, Object payload) {
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri(getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.addHeader("Authorization", AuthTokenProvider.getToken(role))
				.setBody(payload)
				.addFilter(new SensitiveDataFilter())
				.build();
		return requestSpecification;
	}
	
	@Step("Expecting the response to have Content Type as Application/JSON, Status 200 and Response Time Less 7000 ms")
	public static ResponseSpecification responseSpec_OK() {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(7000L))
		.build();
		
		return responseSpecification;
	}
	
	@Step("Expecting the response to have Content Type as Application/JSON and Response Time Less 7000 ms wand status code")
	public static ResponseSpecification responseSpec(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(statusCode)
		.expectResponseTime(Matchers.lessThan(7000L))
		.build();
		
		return responseSpecification;
	
	}
	@Step("Expecting the response to have Content Type as Application/JSON and Response Time Less 7000 ms wand status code")
	public static ResponseSpecification responseSpec_JSON(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(statusCode)
		.expectResponseTime(Matchers.lessThan(7000L))
		.build();
		
		return responseSpecification;
	}
	@Step("Expecting the response to have Content Type as Text and Response Time Less 7000 ms wand status code")
	public static ResponseSpecification responseSpec_TEXT(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectStatusCode(statusCode)
		.expectResponseTime(Matchers.lessThan(7000L))
		.build();
		
		return responseSpecification;
	}
		
}
