package pages.serp.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import utils.Range;

import java.util.List;

/**
 * Created by Alexander on 27.08.2017.
 */
public class FromToFilter extends HtmlElement {

    public void set(Range range) {

        List<WebElement> inputs = findElements(By.cssSelector("input.input__control"));
        set(inputs, 0, range.from());
        set(inputs, 1, range.to());
    }

    private void set(List<WebElement> inputs , int index, String value) {
        if(value != null) {
            WebElement input = inputs.get(index);
            input.clear();
            input.sendKeys(value);
        }
    }
}
