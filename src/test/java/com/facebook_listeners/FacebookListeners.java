package com.facebook_listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FacebookListeners implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		System.out.println("  Test started********** : "+ context.getName()+"**************");
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("method name is >>>>>"+result.getMethod().getMethodName()+" started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Pass : "+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed : "+ result.getName());
		System.out.println("Fail method name is >>>>>"+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipeed : "+ result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" Test finish********** : "+ context.getName()+"**************");
	}

}
