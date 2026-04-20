package com.framework.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.utils.ExtentManager;
import com.framework.utils.LogUtils;
import com.framework.utils.ScreenShot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        String testName = result.getMethod().getMethodName() + " [" + java.util.Arrays.toString(result.getParameters()) + "]";
      ExtentTest extentTest = extent.createTest(testName);
      test.set(extentTest);
        LogUtils.info("Test is Started : " +result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.get().pass("Passed");
        LogUtils.info("Test is passed :" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        String screenShotPath = ScreenShot.TakeScreenShot(result.getMethod().getMethodName());
        test.get().addScreenCaptureFromPath(screenShotPath);
        test.get().fail(result.getThrowable());

        LogUtils.warn("Test is failed :" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        test.get().skip("Test is skipped");
        LogUtils.warn("Test is Skipped :" + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
        LogUtils.info("Log Report is Generated");
    }

    public static ExtentTest getTest(){
        return test.get();
    }

}
