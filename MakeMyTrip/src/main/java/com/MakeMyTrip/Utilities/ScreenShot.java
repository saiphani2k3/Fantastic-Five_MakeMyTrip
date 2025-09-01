package com.MakeMyTrip.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
    public static String filepath =ConfigReader.getProperty("screenshot.path");

    public static File screenShot(WebDriver scdriver, String fileName) {
        File directory = new File(filepath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        File src = ((TakesScreenshot) scdriver).getScreenshotAs(OutputType.FILE);
        String destination = filepath + fileName + "_" + dateFormat.format(date) + ".png";
        File dest = new File(destination);
        try {
            FileHandler.copy(src, dest);
            return dest;
        } catch (IOException e) {
            throw new RuntimeException("Screenshot capture failed: " + e.getMessage());
        }
    }
}
