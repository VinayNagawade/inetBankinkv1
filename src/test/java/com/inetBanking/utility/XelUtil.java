package com.inetBanking.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XelUtil {

	
	public int getRowCount(String filPath) throws IOException {

		int rowcount = 0;
		FileInputStream fis = new FileInputStream(filPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				rowcount = sheet.getLastRowNum();
				workbook.close();
			}
		}
		return rowcount;
	}

	public int getColoum(String filPath) throws IOException {

		int coloumCount = 0;
		FileInputStream fis = new FileInputStream(filPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();
				coloumCount = firstrow.getLastCellNum();
				workbook.close();
			}
		}
		return coloumCount;
	}

	public Object[][] getData(String filPath) throws IOException {
		
		XelUtil d = new XelUtil();
		int rowCount = d.getRowCount(filPath);
		int colCount = d.getColoum(filPath);

		Object abc[][] = new String[rowCount][colCount];
		FileInputStream fis = new FileInputStream(filPath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();

				for (int m = 0; rows.hasNext(); m++) {

					Row r = rows.next();
					Iterator<Cell> b = r.cellIterator();

					for (int j = 0; b.hasNext(); j++) {

						abc[m][j] = b.next().getStringCellValue();

					}
				}

			}
		}
		return abc;
	}
}
