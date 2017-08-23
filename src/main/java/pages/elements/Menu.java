package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class Menu extends TypifiedElement {

    public Menu(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Step("Выбрать пункт меню \"{0}\"")
    public void goToItem(String item) {
        getWrappedElement().findElement(By.linkText(item)).click();
    }
}
