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

public class DemoDaoRunner {
	public static void main(String[] args) throws SQLException {
		
		CustomerProductDBModel customerProductDBModel= CustomerProductDao.getProductInfoFromDB(335879);
		System.out.println(customerProductDBModel);
		
	CustomerProduct	customerProduct = customerProduct = new CustomerProduct(getTimeWithDaysAgo(10),
			"35323435988567", "35323435988567", "35323435988567", 
			getTimeWithDaysAgo(10), Product.NEXUS_2.getCode(), Model.NEXUS_2_BLUE.getCode());

	System.out.println(customerProduct);

	}

}
