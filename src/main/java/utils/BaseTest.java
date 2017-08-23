package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebDriverWait smallWait;
    public int explicitWaitTime = 60;
    public int smallExplicitWaitTime = 20;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
