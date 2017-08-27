package pages.serp.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Alexander on 27.08.2017.
 */
public class FullCheckBoxFilter extends CheckBoxFilter {

    @FindBy(css = ".input__control")
    public TextInput search;

    @Override
    public void select(String checkBoxName) {
        search.clear();
        search.sendKeys(checkBoxName);
        Wait<List<WebElement>> wait = new FluentWait<>(findElements(By.cssSelector("input[type='checkbox']")), new SystemClock(), Sleeper.SYSTEM_SLEEPER);
        wait.until(checkBoxesList -> !checkBoxesList.isEmpty());
        super.select(checkBoxName);
    }


    @Override
    public void select(String[] checkBoxes) {
        for (String checkBox : checkBoxes) {
            select(checkBox);
        }
    }
}
