package com.dataproviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.UserCredentials;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.ExcelReaderUtil2;
import com.api.utils.FakerDataGenerator;
import com.api.utils.JsonReaderUtil;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;

public class DataProviderUtils {
	
	@DataProvider(name = "LoginAPIDataProvider",parallel = true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReaderUtil.loadCSV("testData/LoginCreds.csv",UserBean.class);
		
	}
	
	@DataProvider(name = "CreateJobAPIDataProvider",parallel = true)
    public static Iterator<CreateJobPayload> createJobDataProvider() {
	Iterator<CreateJobBean> createJobBeanIterator	=CSVReaderUtil.loadCSV("testData/CreateJobData.csv", 
			CreateJobBean.class);
	
	   List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
	   CreateJobBean tempBean;
	   CreateJobPayload teamPayload;
	   while(createJobBeanIterator.hasNext()) {
		   tempBean = createJobBeanIterator.next();
		   teamPayload =CreateJobBeanMapper.mapper(tempBean);
		   payloadList.add(teamPayload);
	   }
	   
	   return payloadList.iterator();
		
	}
	
	@DataProvider(name = "CreateJobAPIFakerDataProvider",parallel = true)
    public static Iterator<CreateJobPayload> createJobFakerDataProvider() {
	 String fakerCount = System.getProperty("fakerCount", "5");
	 int fakerCountInt = Integer.parseInt(fakerCount);
	 Iterator<CreateJobPayload> payloadIterator =FakerDataGenerator.generateFakeCreateJobData(fakerCountInt);
	 return payloadIterator;
		
	}
	
	@DataProvider(name = "LoginAPIJsonDataProvider",parallel = true)
	public static Iterator<UserCredentials> LoginAPIJsonDataProvider() {
		return JsonReaderUtil.loadJSON("testData/loginAPITestData.json",UserCredentials[].class);
		
	}
	
	@DataProvider(name = "CreateJobAPIJsonDataProvider",parallel = true)
	public static Iterator<CreateJobPayload> CreateJobAPIJsonDataProvider() {
		return JsonReaderUtil.loadJSON("testData/CreateJobAPIData.json",CreateJobPayload[].class);
		
	}
	
	@DataProvider(name = "LoginAPIExcelDataProvider",parallel = true)
	public static Iterator<UserCredentials> LoginAPIExcelDataProvider() {
		return ExcelReaderUtil2.loadTestData("testData/PhoenxTestData.xlsx", "LoginTestData", UserCredentials.class); 
		
	}
	
	@DataProvider(name = "CreateJobAPIExcelDataProvider",parallel = true)
	public static Iterator<CreateJobPayload> CreateJobAPIExcelDataProvider() {
		Iterator<CreateJobBean> iterator = ExcelReaderUtil2.loadTestData("testData/PhoenxTestData.xlsx", "CreateJobTestData", CreateJobBean.class);
		
		 List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
		   CreateJobBean tempBean;
		   CreateJobPayload teamPayload;
		   while(iterator.hasNext()) {
			   tempBean = iterator.next();
			   teamPayload =CreateJobBeanMapper.mapper(tempBean);
			   payloadList.add(teamPayload);
		   }
		   
		   return payloadList.iterator();
		
	}
	

}
