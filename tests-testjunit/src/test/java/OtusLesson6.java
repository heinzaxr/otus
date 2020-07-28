import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Тест-кейс скрытого объекта, появляющегося при нажатии на button
 * Метод testBootstrap совершает клик по кнопке, ожидает 1 секунду, совершает второй клик, сравнивает alertText
 * Метод GetAlertText получает в скрытом боксе уникальный текст
 */

public class OtusLesson6 {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    private WebElement element;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер включен");
    }
    @Test
    public void testBootstrap() throws InterruptedException {
        driver.get("https://ng-bootstrap.github.io/#/components/alert/examples");
        logger.info("Открыта страница https://ng-bootstrap.github.io/#/components/alert/examples");
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Change message')]"));
        logger.info("Найдена кнопка");
        String alertText = GetAlertText(element);
        logger.info("Сообщение: " + alertText);
        logger.info("Начато ожидание");
        Thread.sleep(1000);
        logger.info("Ожидание закончено");
        String alertText2 = GetAlertText(element);
        logger.info("Сообщение: " + alertText2);
        Assert.assertNotEquals(alertText, alertText2);
    }

    private String GetAlertText(WebElement element){
        element.click();
        WebElement alertBox = driver.findElement(By.xpath("//div[@class='card-body']//ngb-alert[contains(text(), 'Message successfully changed')]"));
        new WebDriverWait(driver, 4).until(visibilityOf(alertBox)); //ждём появления бокса
        return alertBox.getText();
    }


}

