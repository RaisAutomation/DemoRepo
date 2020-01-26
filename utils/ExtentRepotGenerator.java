package com.heroku.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentRepotGenerator extends BaseUtils {

	static ExtentReports report = null;
	public static ExtentTest test = null;

	public String ScreenShotsPath;

	public ExtentRepotGenerator(String NameOfReport) {

		String ReportPath = "";
		ReportPath = System.getProperty("user.dir") + "\\Reports\\";

		NameOfReport = new SimpleDateFormat("yyyy.MM.dd hh-mm-ss").format(new Date()) + " " + NameOfReport;

		String finalPath = ReportPath + "\\" + NameOfReport + "\\" + NameOfReport + ".html";
		ScreenShotsPath = ReportPath + "\\" + NameOfReport + "\\ScreenShots\\";
		report = new ExtentReports(finalPath, false);
		System.out.println("Report Generated");

	}

	public ExtentTest addTestToReport(String TestName) {

		if (report != null) {

			test = report.startTest(TestName);
		}
		return test;

	}

	public void addTestInformation(LogStatus status, String Description) {

		if (report != null)
			test.log(status, Description);

	}

	public void addTestInformationWithScreenShot(LogStatus status, String Description, String ScreenShotFileName)
			throws IOException {

		String ScreenShotLocation;
		if (report != null) {
			test.log(status, Description);
			ScreenShotLocation = getCurrentScreenShot(ScreenShotFileName);
			test.log(LogStatus.INFO, test.addScreenCapture(ScreenShotLocation));
		}

	}

	public void reportLogger() {
		if (report != null)
			report.endTest(test);
	}

	public void reportEnd() {
		if (report != null)
			report.flush();
	}

	public String getCurrentScreenShot(String FileName) throws IOException {

		String Date = new SimpleDateFormat("yyyy.MM.dd hh-mm-ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = ScreenShotsPath + Date + "_" + FileName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
