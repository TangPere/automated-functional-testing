package com.peretang.it.testcase.google;

import com.peretang.it.base.BaseFunctionalTesting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pere
 * Date 2017-05-20
 */
public class GoogleTest extends BaseFunctionalTesting {

    @Test
    public void goToGoogleSearch () {
        // now use webDriver to visit Google
        webDriver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = webDriver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + webDriver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(webDriver,10)).until(new ExpectedCondition<Boolean>() {

            public Boolean apply (WebDriver d) {

                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + webDriver.getTitle());

    }
}
