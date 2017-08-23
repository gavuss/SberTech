package pages.market;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import pages.elements.Menu;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class MarketPage extends AbstractYandexPage {

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".topmenu__list")
    public Menu tabs;


}
