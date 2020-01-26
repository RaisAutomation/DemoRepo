package com.heroku.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExtractor {

	static String ProjectPath;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	public ExcelExtractor(String excelPath, String sheetName) {

		try {
			ProjectPath = System.getProperty("user.dir");
//			workBook = new XSSFWorkbook(ProjectPath + "\\Excel\\data.xlsx");
			workBook = new XSSFWorkbook(excelPath);

			sheet = workBook.getSheet(sheetName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public int getRowCount() {

		int rowCount = 0;
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count:" + rowCount);
		return rowCount;

	}

	public int getColCount() {

		int colCount = 0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Col Count:" + colCount);
		return colCount;

	}

	public String getCellDataString(int rowNumber, int colNumber) {

		String cellData = "";
		cellData = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
//		System.out.println(cellData);
		return cellData;

	}

	public double getCellDataNumeric(int rowNumber, int colNumber) {

		double cellData = 0;
		cellData = sheet.getRow(rowNumber).getCell(colNumber).getNumericCellValue();
//		System.out.println(cellData);
		return cellData;

	}

	public Object[][] testData(String excelPath, String sheetName) {
//		ExcelExtractor excel = new ExcelExtractor(excelPath, sheetName);
		int rowCount = getRowCount();
		int colCount = getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = getCellDataString(i, j);
//				System.out.println(cellData);
				data[i - 1][j] = cellData;
			}

		}

		return data;
	}

}
