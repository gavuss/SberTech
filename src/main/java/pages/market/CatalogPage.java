package pages.market;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import pages.elements.Menu;

import java.util.List;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class CatalogPage extends AbstractYandexPage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".catalog-menu")
    public Menu leftMenu;

}
