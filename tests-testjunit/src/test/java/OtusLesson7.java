import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtusLesson7 {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер включен");
    }

    @Test
    public void testAlert()  {
        driver.get("https://dwweb.ru/page/js/002_alert_javascript.html");
        logger.info("Открыта страница dwweb.ru c alert_javascript");
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        logger.info("Ждем алерт");
        Alert alert = driver.switchTo().alert();
        logger.info("Выбираем алерт");
        alert.accept();
        logger.info("Соглашаемся с алертом");

    }
}
