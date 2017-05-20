package com.peretang.it.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pere
 * Date 2017-05-20
 */
public class BaseFunctionalTesting {

    protected WebDriver webDriver;

    /**
     * init WebDriver for each test case
     */
    @Before
    public void initWebDriver () {

        // // Optional, if not specified, WebDriver will search your path for chromedriver.
        File webDriverFile = new File("WebDriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",webDriverFile.getAbsolutePath());

        // When the ChromeDrvier is initialized, will using System.getProperty() to get the config.
        webDriver = new ChromeDriver();

        // Configure an implicit wait time
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    /**
     * Destroy WebDriver after each test case
     */
    @After
    public void destroyWebDriver () {

        webDriver.quit();
    }
}
