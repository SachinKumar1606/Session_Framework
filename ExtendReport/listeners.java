package ExtendReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {
    private extentReport ExtentReport;
    ExtentReports extent = extentReport.extentReportGenerator();
    ExtentTest test;
    public void onFinish(ITestContext context) {
        extent.flush();
    }


    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "No Issues encountered!");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }


    public void onTestSkipped(ITestResult result) {
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


    public void onStart(ITestContext context) {
    }
}
