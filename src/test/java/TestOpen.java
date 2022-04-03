import component.HighLight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.MainPage;

import webDriverFactory.Browsers;
import webDriverFactory.WebDriverFactory;
import lombok.val;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestOpen  {
    private static Logger logger = LogManager.getLogger(TestOpen.class);
    private WebDriver driver;
    //public String highLight;
    public static MainPage mainPage;
    private String baseUrl = System.getProperty("webdriver.base.url");
    protected Actions actions;

    
   // private long waitSec = new Integer(System.getProperty("webdriver.timeouts.implicitlywait"));


    @Before
    public  void setup(){

        logger.info("-------------------новый тест----------------------");
    }

    @After
    public void closeDriver() {
        if (driver != null)
            driver.quit();

        logger.info("драйвер закрыт");

        logger.info("-------------------тест окончен---------------------");
    }

   // Проверяем открылась ли главная страница (baseUrl)
    @Test
    public  void validMainPage() throws InterruptedException {
     //  System.out.println(Environment.getVariable("browser")+baseUrl);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver =  WebDriverFactory.createDriver(Browsers.CHROME,options);
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
              driver.get(baseUrl);
       mainPage=new MainPage(driver);
      //  actions = new Actions(driver);
        Assert.assertEquals("Авторские онлайн‑курсы для профессионалов",mainPage.headerMainPage.getText());
    //  Thread.sleep(1000);
        System.out.println(mainPage.headerMainPage.getText());
        logger.info("Valid main page");
    }
@Test
    public void actionsMouse() throws InterruptedException {
  ChromeOptions options = new ChromeOptions();
  options.addArguments("--kiosk");

  //  options.setPageLoadStrategy(PageLoadStrategy.EAGER);

    driver = WebDriverFactory.createDriver(Browsers.CHROME,options) ;
    // driver =  WebDriverFactory.createDriver();
    EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
    eventFiringWebDriver.register(new HighLight());
    driver = eventFiringWebDriver;
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.get(baseUrl);
    mainPage=new MainPage(driver);
    actions = new Actions(driver);
    //List<LocalDate> datesG = mainPage.getDateCourses();
    List lc = mainPage.listCourses;
    System.out.println(mainPage.filterElementByText(mainPage.listCourses,"специализация"));
//  ArrayList list=  new ArrayList(mainPage.listCourses);
//    for (int i = 0; i < list.size(); i++)
//   {
////
//        System.out.println(list.get(i) );
//    }
//            .stream()
//            .filter(val -> val.$("lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse"))
//            .getText()
//            .trim()
//            .toLowerCase()
//            .contains("qa".trim().toLowerCase(Locale.ROOT));



   mainPage.moveToElementAction(actions, mainPage.firstCourse);

    Thread.sleep(1000);
//driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div[2]/a[1]/div/div[1]/picture/img")).click();
   HighLight.highLightOn(mainPage.firstCourse, driver);
  Thread.sleep(1000);

//  --------------------------------test
//    actions.moveToElement(mainPage.firstCourse).
//            pause(6000).
//            click(mainPage.firstCourse).
//            pause(6000).build().perform();


    HighLight.highLightOff(mainPage.firstCourse, driver);
//   // driver.findElement(By.id("su")).click();
    //mainPage.moveToElementAndClickAction(actions, mainPage.firstCourse);
   // Thread.sleep(3000);
    //

//actions.build()
    //         .moveToElementAction(actions, mainPage.testingSubmenuItem)
//            .moveToElementAction(actions, mainPage.dropDownTrigger)
//            .moveToElementAndClickAction(actions, mainPage.qaCourseMenuElement);
//actions.moveToElement(mainPage.coursesMenuItem)
//        .pause(1000)
//        .moveToElement(mainPage.testingSubmenuItem)
//        .pause(1000)
//        .moveToElement(mainPage.dropDownTrigger)
//        .pause(1000)
//        .moveToElement(mainPage.qaCourseMenuElement)
//        .build()
//        .perform();


           // .checkTitle("QA Engineer. Basic");

//HighLight.highLightOn(mainPage.headerMainPage, driver);
//mainPage.headerMainPage.click();
logger.info("Highlight verify");
    }
}
