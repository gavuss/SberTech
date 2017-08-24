import org.junit.Test;
import pages.market.CatalogPage;
import pages.market.MarketPage;
import pages.search.YandexPage;
import utils.BaseTest;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class SberTechTest extends BaseTest {

    @Test
    public void test() {
            new YandexPage(driver).open()
                    .tabs.goToItem("Маркет");
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
//7.      Выбрать производителя HP и Lenovo
//
//8.      Нажать кнопку Применить.
//
//9.      Проверить, что элементов на странице 12.
//
//            10.  Запомнить первый элемент в списке.
//
//11.  В поисковую строку ввести запомненное значение.
//
//            12.  Найти и проверить, что наименование товара соответствует запомненному значению.
}
