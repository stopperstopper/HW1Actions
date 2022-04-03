package pages;

import component.CoursePage;
import component.EnumMonth;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import webDriverFactory.AbstractCloneWebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends AbstractCloneWebDriver implements FilterElement{

        public MainPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
            // this.driver = driver;
        }

        //заголовок  который есть только на главной странице
        @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div/h1")
        public WebElement headerMainPage;

        // локаторы actions
    @FindBy(xpath = ".//p[@class='header2-menu__item-text' and text()='Курсы']")
   public WebElement coursesMenuItem;

    @FindBy(xpath = "//div[contains(@class, 'header2-menu__subdropdown-wrapper')]/a[contains(@href, '/categories/testing')]")
    public WebElement testingSubmenuItem;

    @FindBy(xpath = "//a[contains(@title, 'Тестирование')]/div[contains(@class, 'js-menu-subdropdown-trigger')]")
    public WebElement dropDownTrigger;
    @FindBy(css = ".course-header2__title")
    public WebElement courseTitle;
    @FindBy(xpath = "//a[contains(@href, '/lessons/qa-engineer/')]")
    public WebElement qaCourseMenuElement;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[2]/a[1]/div/div[1]/picture/img")
    public WebElement firstCourse;
//    @FindBy(css = ".lessons__new-item-title.lessons__new-item-title_with-tags.lessons__new-item-title_with-bg.js-ellipse")
  @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[4]/div[2]/a[12]/div/div[4]")
   // @FindBys({
         //   @FindBy(css = ".lessons__new-item-title.lessons__new-item-title_with-tags.lessons__new-item-title_with-bg.js-ellipse"),

      //      @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1)")
    //})
    public List<WebElement> listCourses;

   // -----kod Pasha B дата курсов
//    public List<LocalDate> getDateCourses() {
//        List<LocalDate> dates = listCourses.stream()
//                .map(course -> {
//                    WebElement data = course.findElement(By.cssSelector(".lessons__new-item-start"));
//                    String dataString = data.getText();
//                    String[] dataCoursesList = dataString.split("\\s+");
////                    String europeanDatePattern = "dd.MM.yyyy";
////                    DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
//                    EnumMonth month = null;
//                    for (EnumMonth enumMonth : EnumMonth.values()) {
//                        if (enumMonth.getName().equals(dataCoursesList[1])) {
//                            month = enumMonth;
//                            break;
//                        }
//                    }
//                    //                    LocalDate.parse(dataString,europeanDateFormatter);
//                    assert month != null;
//
//                    return LocalDate.of(LocalDate.now().getYear(), month.getMonthNumber(), Integer.parseInt(dataCoursesList[0]));
//
//                }).sorted().collect(Collectors.toList());
//        //dates.get(0).compareTo(dates.get(1));
//        return dates;
//    }
//----------------------------

    public MainPage moveToElementAction(Actions actions, WebElement element) {
        actions.moveToElement(element).perform();
        return this;
    }

    public CoursePage moveToElementAndClickAction(Actions actions, WebElement element) {
        actions.moveToElement(element).build().perform();
        element.click();
        return new CoursePage(driver);
            }
    public void checkTitle(String expectedValue) {
        Assertions.assertEquals(expectedValue, this.courseTitle.getText());
    }
}
