package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.api.constant.Role.*;
import com.api.request.model.Detail;
import com.api.services.DashboardService;
import static com.api.utils.SpecUtil.*;

public class DetailsAPITest {
	
	private DashboardService dashBoardService;
	private Detail detailPayload;
	
	@BeforeMethod(description = "Instantiating the DashBoard service and creating detail payload")
	public void setup() {
		dashBoardService = new DashboardService();
		detailPayload = new Detail("created_today");
	}
	
	@Test(description = "Verify if Details API is working properly", groups = {"api","smoke","e2e"})
	public void detailAPITest() {
		dashBoardService.details(FD, detailPayload)
		.then()
		.spec(responseSpec_OK())
		.body("message", equalTo("Success"));
		
	}

}
