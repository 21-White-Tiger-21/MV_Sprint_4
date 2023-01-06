package scooterTest.inFireFoxBrowserTest;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


//базовый класс для подключения драйвера "FireFox"
public class connectionFireFox {
    WebDriver driver;
    @Before

    //подключение браузера
    public void open() {
        driver = new FirefoxDriver();

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