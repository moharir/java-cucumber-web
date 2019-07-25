package cigniti.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


	@Override
	public void onStart(ITestContext context) {
			System.out.println("\n*************** Suite " + context.getSuite().getName() + " Started ***************\n");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("\n*************** Suite " + context.getSuite().getName() + " Finished ***************\n");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
