package webdriverfactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Locale;

public class WebDriverFactory {
  public static WebDriver getDriver(String browserType, MutableCapabilities webDriverOptions){
    WebDriver driver = null;
    switch (browserType.toLowerCase(Locale.ROOT)){
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver((FirefoxOptions) webDriverOptions);
        break;
      case "opera":
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver((OperaOptions) webDriverOptions);
        break;
      default:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver((ChromeOptions) webDriverOptions);
    }
    return driver;


  }
}
