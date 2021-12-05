package helpler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import common.GlobleVariables;

import java.io.IOException;


public class ReportHelper {
    public static ExtentHtmlReporter htmlReporter;
    public static  ExtentReports extent;

    public  static ExtentReports getExtent() {
        htmlReporter = new ExtentHtmlReporter("./output/report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.attachReporter();

        return extent;
    }

    public static ExtentTest getTest() {
        return GlobleVariables.logger.get();
    }
    public static void logFail(String actual,String expected,String message,String path){
        try {
            GlobleVariables.logger.get().fail(message + "<br>" + "actual: " + actual + "<br>Expected: " + expected , MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
