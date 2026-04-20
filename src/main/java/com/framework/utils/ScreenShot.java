package com.framework.utils;

import com.framework.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.framework.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static String TakeScreenShot(String testName){

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenShotName = testName  + "_" + timeStamp + ".png";
        String destination = "screenshots/" + screenShotName;

        try{
            new File("screenshots").mkdirs();
            File source = ((TakesScreenshot) BaseClass.getDriver())
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File(destination));
        }
        catch (IOException e){
            LogUtils.error("Screenshot failed: " + e.getMessage());
            return null;
        }


       return destination;
    }
}
