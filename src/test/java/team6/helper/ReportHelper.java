package team6.helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;

public class ReportHelper {
    public static ExtentTest extentTest;

    public static void setTest(ExtentTest extent) {
        extentTest = extent;
    }
    public static ExtentTest getTest() {
        return extentTest;
    }
    public static void logFail(String message,String path){
        try {
            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
