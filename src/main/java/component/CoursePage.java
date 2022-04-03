package component;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CoursePage extends MainPage {


    public CoursePage(WebDriver driver) {
        super(driver);
    }
//List<String> list = Arrays.asList("/html/body/div[1]/div/div[1]/div[3]/div/div[2]/a[3]/div/div[3]");


//lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse

//    public CoursePage waitForUrlContains(String urlPath) {
//        wait = new WebDriverWait(driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS));
//        wait.until(ExpectedConditions.urlContains(urlPath));
//        return this;
//    }

    }

