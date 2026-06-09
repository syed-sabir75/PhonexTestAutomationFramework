package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poiji.bind.Poiji;

public class ExcelReaderUtil {
    
	private ExcelReaderUtil() {
		
	}
	public static<T> Iterator<T> loadTestData(String xlsxFile,String sheetname,Class<T> clazz) {
		// APACHE POI OOXML LIB
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("testData/PhoenxTestData.xlsx");
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFSheet mySheet = myWorkBook.getSheet(sheetname);
		
	   List<T> dataList	= Poiji.fromExcel(mySheet, clazz);
	   return dataList.iterator();

		
	}
}
