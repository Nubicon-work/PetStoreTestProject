package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(css = "iframe[loading='lazy']")
    private SelenideElement map;
}
