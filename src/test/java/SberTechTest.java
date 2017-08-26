import org.junit.Test;
import org.openqa.selenium.By;
import pages.market.CatalogPage;
import pages.market.MarketPage;
import pages.search.YandexPage;
import utils.BaseTest;

import java.util.function.BooleanSupplier;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class SberTechTest extends BaseTest {

    @Test
    public void test() {
        YandexPage mainPage = new YandexPage(driver).open();

        mainPage.waitUntilIsDisplayed(((driver) -> driver.findElement(By.id("ыфоваолы")).isDisplayed()));

        mainPage.tabs.goToItem("Маркет");

        new MarketPage(driver)
                .tabs.goToItem("Компьютеры");
        new CatalogPage(driver)
                .leftMenu.goToItem("Ноутбуки");

    }


//     1. Открыть браузер Chrome и развернуть на весь экран.
//
//     2. Зайти на yandex.ru.
//
//     3. Перейти в яндекс маркет
//
//     4. Выбрать Компьютеры
//
//     5. Выбрать раздел Ноутбуки
//
//     6. Задать параметр поиска до 30000 рублей.
//
//     7. Выбрать производителя HP и Lenovo
//
//     8. Нажать кнопку Применить.
//
//     9. Проверить, что элементов на странице 12.
//
//     10. Запомнить первый элемент в списке.
//
//     11. В поисковую строку ввести запомненное значение.
//
//     12. Найти и проверить, что наименование товара соответствует запомненному значению.


//· Необходимо параметризовать и вынести часто используемые/дублируемые инструкции в отдельные функции.
//· Предусмотреть использование recovery-действий, в случае неожиданного результата.
//· В каждом действии по переходу должны быть встроены логические проверки-ожидания открытия страницы.
//· Каркас –фреймворк unit-тестирования J-Unit.
//· Результатом выполнения должен быть Yandex.Allure отчет.
//· Проект должен быть оформлен как артефакт Maven.
//· Исходный код проекта должен быть выложен на github или bitbucket.
}
