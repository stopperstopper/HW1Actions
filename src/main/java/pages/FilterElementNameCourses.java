package pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FilterElementNameCourses {
  public static List<WebElement> getFiltredCourses(List<WebElement> elements, String text){
    return  elements
                .stream()
                .filter(val->val.getText().trim().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT).trim())).collect(Collectors.toList());

  }
}
