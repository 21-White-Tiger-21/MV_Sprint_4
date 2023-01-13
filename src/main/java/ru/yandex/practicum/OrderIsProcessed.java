package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//класс страницы "Заказ оформлен"
public class OrderIsProcessed {
    private final WebDriver driver;
    //локатор всплывающего окна "Заказ оформлен"
    private final By orderIsProcessed = By.xpath("//div[text()='Заказ оформлен']");

    public OrderIsProcessed(WebDriver driver) {
        this.driver = driver;
    }

    //метод возвращает истину, если всплывающее окно "Заказ оформлен" отображено
    public boolean orderIsProcessedTextIsDisplayed() {
        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}
