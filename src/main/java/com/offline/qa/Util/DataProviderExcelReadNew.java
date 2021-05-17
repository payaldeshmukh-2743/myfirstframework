package com.offline.qa.Util;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.offline.qa.Base.TestBase;

public class DataProviderExcelReadNew extends TestBase {
	static FileInputStream file = null;
	static Workbook book = null;
	static Sheet sheet = null;

	public DataProviderExcelReadNew() throws Exception {
		super();
	}

	@DataProvider(name = "ExcelData")
	public static Object[][] ExcelData(Method methodName) throws Exception {

		file = new FileInputStream(config.getProperty("ExcelDataPath"));

		book = WorkbookFactory.create(file);

		if (methodName.getName().equalsIgnoreCase("RegisterNewMemberWithDataProviderExcelTest")) {

			sheet = book.getSheet("RegisterNewMember");
		} else if (methodName.getName().equalsIgnoreCase("LoginWithDataProviderExcelTest")) {

			sheet = book.getSheet("Login");
		} else if (methodName.getName().equalsIgnoreCase("AddUserWithDataProviderExcelTest")) {

			sheet = book.getSheet("AddUser");
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				String datavalue = sheet.getRow(i + 1).getCell(k).toString();

				data[i][k] = datavalue;

			}
		}
		return data;
	}
}
