package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
  private static ExtentReports extent;
  public static synchronized ExtentReports getInstance(){
      if(extent == null) {
          ExtentSparkReporter spark = new ExtentSparkReporter("Reports/TestResults.html");
          spark.config().setReportName("Selenium Test Report");
          spark.config().setDocumentTitle("Test Results");
          extent = new ExtentReports();
          extent.attachReporter(spark);
          extent.setSystemInfo("os", System.getProperty("os.name"));
          extent.setSystemInfo("Tester", "Yaser Bashir");
      }
      return extent;
  }

}
