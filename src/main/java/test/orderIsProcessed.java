package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//класс страницы "Заказ оформлен"
public class orderIsProcessed {
    private final WebDriver driver;

    public orderIsProcessed(WebDriver driver) {

        this.driver = driver;
    }

    //локатор всплывающего окна "Заказ оформлен"
    private final By orderIsProcessed = By.xpath("//div[text()='Заказ оформлен']");

    //метод возвращает истину, если всплывающее окно "Заказ оформлен" отображено
    public boolean orderIsProcessedTextIsDisplayed() {

        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}
