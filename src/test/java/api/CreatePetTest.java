package api;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreatePetTest {

//    private WebDriver driver;
//    WebDriverManager.chromedriver().architecture(Architecture.ARM64).setup();
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--remote-allow-origins=*");
//    driver = new ChromeDriver(options);
//    driver.manage().window().maximize();
//    driver.get("https://www.youtube.com/");

    @Test
    public void createPetTest() {

    }

    @AfterTest
    public void deleteCreatedPet() {

    }
}
