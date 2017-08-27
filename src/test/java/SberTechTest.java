import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import pages.market.CatalogPage;
import pages.market.MarketPage;
import pages.search.YandexPage;
import pages.serp.SearchResultPage;
import pages.serp.SerpPage;
import pages.serp.filters.CheckBoxFilter;
import pages.serp.filters.FromToFilter;
import ru.yandex.qatools.allure.annotations.Step;
import utils.BaseTest;
import utils.Range;

import java.util.Arrays;
import java.util.Collection;

import static utils.Range.range;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
@RunWith(Parameterized.class)
public class SberTechTest extends BaseTest {

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {"Ноутбуки", range().to("30000"), new String[]{"HP", "Lenovo"}},
                {"Планшеты", range().from("20000").to("25000"), new String[]{"Acer", "DELL"}}
        });
    }

    @Parameter(0)
    public String goodsGroup;

    @Parameter(1)
    public Range range;

    @Parameter(2)
    public String[] developers;

    @Test
    public void test() {
        YandexPage mainPage = new YandexPage(driver).open();
        mainPage.tabs.goToItem("Маркет");
        new MarketPage(driver)
                .tabs.goToItem("Компьютеры");
        new CatalogPage(driver)
                .leftMenu.goToItem(goodsGroup);

        SerpPage serpPage = new SerpPage(driver);

        serpPage.getSearchFilter(FromToFilter.class, "Цена, руб.")
                .set(range);

        serpPage.getSearchFilter(CheckBoxFilter.class, "Производитель")
                .select(developers);

        serpPage = serpPage.applyFilters();

        assertSearchSize(12, serpPage);

        String nameResult = serpPage.searchResults.get(0).title.getText();
        serpPage.search(nameResult);

        SearchResultPage searchResultPage = new SearchResultPage(driver);

        assertProductTitle(nameResult, searchResultPage);
    }

    @Step("Проверить, количество результатов выдачи = {0}")
    public void assertSearchSize(int expected, SerpPage page) {
        int actualResult = page.searchResults.size();
        Assert.assertEquals("Ожидаемое количество в выдаче - " + expected + "\n" +
                        "Фактическое количество в выдаче - " + actualResult,
                actualResult, expected);
    }

    @Step("Проверить, название продуктаи = {0}")
    public void assertProductTitle(String expected, SearchResultPage page) {
        String actualResult = page.header.getText();
        Assert.assertEquals("Ожидаемое название продукта - " + expected + "\n" +
                        "Фактическое количество в выдаче - " + actualResult,
                actualResult, expected);
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


// Необходимо параметризовать и вынести часто используемые/дублируемые инструкции в отдельные функции.
// Предусмотреть использование recovery-действий, в случае неожиданного результата.
// В каждом действии по переходу должны быть встроены логические проверки-ожидания открытия страницы.
// Каркас – фреймворк unit-тестирования J-Unit.
// Результатом выполнения должен быть Yandex.Allure отчет.
// Проект должен быть оформлен как артефакт Maven.
// Исходный код проекта должен быть выложен на github или bitbucket.

//1. Открыть браузер Chrome и развернуть на весь экран.
//2. Зайти на yandex.ru.
//3. Перейти в яндекс маркет
//4. Выбрать раздел Компьютеры
//5. Выбрать раздел Планшеты
//6. Задать параметр поиска от 20000 рублей.
//7. Задать параметр поиска до 25000 рублей.
//8. Выбрать производителей Acer и DELL
//9. Нажать кнопку Применить.
//10. Проверить, что элементов на странице 12.
//11. Запомнить первый элемент в списке.
//12. В поисковую строку ввести запомненное значение.
//13. Найти и проверить, что наименование товара соответствует запомненному значению.
}
