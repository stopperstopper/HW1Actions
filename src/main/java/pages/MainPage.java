package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriverfactory.AbstractCloneWebDriver;
import java.util.List;

public class MainPage extends AbstractCloneWebDriver {
  public MainPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }


  @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div/h1")
  public WebElement headerMainPage; //заголовок  который есть только на главной странице

  @FindBy(css = ".course-header2__title")
  public WebElement courseTitle; //Заголовок курса

  @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[2]/a[1]/div/div[1]/picture/img")
  public WebElement firstCourse; //1 курс

  @FindBy(css = ".lessons__new-item-title.lessons__new-item-title_with-bg.js-ellipse")
  public  List<WebElement> listCourses; //список курсов

  @FindBy(css = ".lessons__new-item-title.lessons__new-item-title_with-bg.lessons__new-item-title_bundle")
  public  List<WebElement> listSpecialization; //список специализаций

}
