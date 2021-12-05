package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import common.GlobleVariables;
import common.WebDriverFactoryStaticThreadLocal;
import helpler.ReportHelper;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseTestListener implements ITestListener {
    public static ExtentReports extent;
    protected static String evName;
    public static ExtentTest log;
    @Override
    public void onStart(ITestContext context) {
        System.out.println( "-----on start");


        evName  = context.getCurrentXmlTest().getParameter("environment");
        GlobleVariables.environment = evName;
        GlobleVariables.ExT = ReportHelper.getExtent();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
        log = GlobleVariables.ExT.createTest(result.getMethod().getMethodName());
        GlobleVariables.logger.set(log);

    }


    @SneakyThrows
    @Override
    public  void onTestSuccess(ITestResult result) {
        Thread.sleep(2000);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        GlobleVariables.ExT.flush();
    }
}
