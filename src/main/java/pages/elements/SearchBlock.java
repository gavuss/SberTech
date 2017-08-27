package pages.elements;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Alexander on 27.08.2017.
 */
public class SearchBlock extends HtmlElement {

    @FindBys({@FindBy(id = "header-search")})
    public TextInput searchInput;

    @FindBys({@FindBy(css = ".search2__button")})
    public TextInput searchButton;

    public void search(String value) {
        searchInput.clear();
        searchInput.sendKeys(value);
        searchButton.click();
    }

}
