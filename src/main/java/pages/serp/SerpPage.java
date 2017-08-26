package pages.serp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractYandexPage;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class SerpPage extends AbstractYandexPage {

    @Override
    public WebElement logo() {
        return getDriver().findElement(By.cssSelector(".home-logo"));
    }

    public SerpPage(WebDriver driver) {
        super(driver);
    }

}
