package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.Search;
import com.api.services.JobService;
import com.api.utils.SpecUtil;

public class SearchAPITest {
	
	private JobService jonService;
	private static final String JOB_NUMBER= "JOB_335905";
	private Search searchPayload;
	
	@BeforeMethod(description = "Instantiating the JobService and Creating the search payload")
	public void setup() {
		jonService = new JobService();
		searchPayload = new Search(JOB_NUMBER);
	}
	
	@Test(description = "verify if the search api is working properly", groups = {"e2e","smoke","api"})
	public void searchAPITest() {
		jonService.search(Role.FD, searchPayload)
		.then()
		.spec(SpecUtil.responseSpec_OK())
		.body("message", Matchers.equalTo("Success"));
	}

}
