package org.example.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzers implements IRetryAnalyzer {

    private int retryCount = 0;
    public static final int maxRetry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(retryCount<maxRetry){
            retryCount++;
            return true;
        }

        return false;
    }
}
