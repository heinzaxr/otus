import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Тест-кейс открытия главной страницы
 * Открывает в браузере Chrome страницу https://otus.ru/
 * Проверяет title страницы
 * Логирует шаги теста с помощью log4j
 */

public class SampleTest {

        protected static WebDriver driver;
        private Logger logger = LogManager.getLogger(SampleTest.class);



        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Драйвер включен");
        }
        @Test
        public void openPage() {
            driver.get("https://otus.ru/");
            logger.info("Открыта страница OTUS");
            driver.getTitle();
            Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям",driver.getTitle());
            logger.info("Титул загрузился");
            if (driver != null) {
                driver.quit();
            }

            driver = new ChromeDriver();
            driver.get("https://otus.ru/");
            logger.info("Снова открыта страница OTUS.RU");
        }



        @After
        public void setDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }





