import annotation.AnotationActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.FilterElementNameCourses;
import pages.MainPage;
import webdriverfactory.Environment;
import webdriverfactory.WebDriverFactory;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class MainTests {
  private static Logger logger = LogManager.getLogger(MainTests.class);
  private WebDriver driver;
  public static MainPage mainPage;
  private String baseUrl = Environment.getVariable("webdriver.base.url");
  protected Actions actions;
  protected String browserType = Environment.getVariable("browser").toLowerCase(Locale.ROOT).trim();
  protected String nameListCourses = "dev";

  protected void preSet(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk");
    driver = WebDriverFactory.getDriver(browserType,options);
    EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
    eventFiringWebDriver.register(new AnotationActions());
    driver = eventFiringWebDriver;
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.get(baseUrl);
    mainPage=new MainPage(driver);
  }

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

  /*
   Проверяем открылась ли главная страница (baseUrl)
   */
  @Test
  @Order(1)
  public  void validMainPage() throws InterruptedException {
    preSet();
    Assert.assertEquals("Авторские онлайн‑курсы для профессионалов",mainPage.headerMainPage.getText());
    logger.info("Valid main page");
  }

  /*
  Выводим список курсов содержащих text подсвечиваем 1 курс и кликаем на нем
   */
  @Test
  @Order(2)
  public void actionsMouse() {
    preSet();
    actions = new Actions(driver);
    String firstListCourse= mainPage.listCourses.get(0).getText();

    /*
    Получаем список курсов содержащих в себе text и выводим в консоль
    */
    List<WebElement> listCoursesContainsNameListCourses= new ArrayList<>();
    listCoursesContainsNameListCourses.addAll(FilterElementNameCourses.getFiltredCourses(mainPage.listCourses,nameListCourses));
    listCoursesContainsNameListCourses.addAll(FilterElementNameCourses.getFiltredCourses(mainPage.listSpecialization,nameListCourses));
    listCoursesContainsNameListCourses.forEach(course-> {
      System.out.println("Курсы: "+course.getText());
    });
    logger.info("Список выведен в консоль");
    /*
    Подсвечиваем 1 курс и кликаем
    */
    actions.moveToElement(mainPage.firstCourse)
    .pause(6000)
    .click(mainPage.firstCourse)
    .pause(6000).build().perform();
    logger.info("Подсветка и переход на страничку 1 курса");

    /*
    Проверяем что при клике на 1 курс попали на его страничку
    */
    Assert.assertEquals(firstListCourse,mainPage.courseTitle.getText());

    logger.info("Перешли на страницу 1 курса");
  }
}
