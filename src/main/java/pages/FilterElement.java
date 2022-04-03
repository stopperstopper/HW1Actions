package pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public interface FilterElement {
    default WebElement filterElementByText(List<WebElement> elements, String text){
        return elements
                .stream()
                .filter(val->val.getText().trim().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT).trim()))
                .findAny()
                .get();
    }
}
