package com.database.dao;

import static com.api.utils.DateTimeUtil.getTimeWithDaysAgo;

import java.sql.SQLException;

import org.testng.Assert;

import com.api.constant.Model;
import com.api.constant.Product;
import com.api.request.model.Customer;
import com.api.request.model.CustomerProduct;
import com.database.model.CustomerAddressDBModel;
import com.database.model.CustomerDBModel;
import com.database.model.CustomerProductDBModel;
import com.database.model.JobHeadModel;

public class DemoDaoRunner {
	public static void main(String[] args) throws SQLException {
		
		JobHeadModel jobHeadModel = JobHeadDao.getDataFromJobHead(335924);
		System.out.println(jobHeadModel);

	}

}
