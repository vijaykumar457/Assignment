package com.managers;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener {
	
	WebDriver driver=null;
	String filePath = "D:\\Framework_reference_Docs\\Automation_Framework_Durga\\Automation_Framework\\SCREENSHOTS";


	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}
	
	/*
	 * @Override public void onTestFailure(ITestResult result) {
	 * System.out.println("***** Error "+result.getName()+" test has failed *****");
	 * String methodName=result.getName().toString().trim(); ITestContext context =
	 * result.getTestContext(); WebDriver driver =
	 * (WebDriver)context.getAttribute("driver"); takeScreenShot(methodName,
	 * driver); }
	 * 
	 * public void takeScreenShot(String methodName, WebDriver driver) { File
	 * scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //The
	 * below method will save the screen shot in d drive with test method name try {
	 * FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
	 * System.out.println("***Placed screen shot in "+filePath+" ***"); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */
		
		  public void onTestFailure(ITestResult result) {
		  System.out.println("*** Test execution " + result.getMethod().getMethodName()
		  + " failed..."); ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		  }
		 
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}