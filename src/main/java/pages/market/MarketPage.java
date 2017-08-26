package pages.market;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import pages.elements.Menu;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class MarketPage extends AbstractYandexPage {

    @Override
    public WebElement logo() {
        return getDriver().findElement(By.cssSelector(".home-logo"));
    }

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".topmenu__list")
    public Menu tabs;


}
