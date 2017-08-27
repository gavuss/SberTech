package pages.serp.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Alexander on 27.08.2017.
 */
public class CheckBoxFilter extends HtmlElement {

    @FindBy(css = ".button")
    public Button button;

    public void select(String checkBoxName) {
        WebElement label = findElement(By.xpath("//label[.='" + checkBoxName + "']"));
        WebElement checkbox = label.findElement(By.xpath("..//input[@type='checkbox']"));
        if (!checkbox.isSelected()) {
            label.click();
        }
    }

    public void select(String[] checkBoxes) {
        FullCheckBoxFilter fullFilter = null;
        for (String checkBox : checkBoxes) {
            try {
                select(checkBox);
            } catch (Exception e) {
                if (fullFilter == null) {
                    button.click();
                    fullFilter = HtmlElementLoader
                            .createHtmlElement(FullCheckBoxFilter.class, getWrappedElement(), getName());
                    fullFilter.select(checkBox);
                }
            }
        }
    }

}
