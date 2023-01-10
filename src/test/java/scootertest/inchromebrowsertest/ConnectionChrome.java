package scootertest.inchromebrowsertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//базовый класс для подключения драйвера "Chrome"
public class ConnectionChrome {
    WebDriver driver;

    //подключение драйвера, браузера
    @Before
    public void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //неявное ожидание в 5 секунд
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //перевод браузера из оконного режима, в полноэкранный
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        //закрывает браузер
        driver.quit();
    }
}