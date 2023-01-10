package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//класс страницы "Хотите оформить заказ?"
public class WindowOrderIsOk {
    private final WebDriver driver;
    //Кнопка "Да" в всплывающем окне "Хотите оформить заказ?"
    private final By okButton = By.xpath(".//*[text()='Да']");

    public WindowOrderIsOk(WebDriver driver) {
        this.driver = driver;
    }

    //метод для нажатия на кнопку "Да"
    public void clickOkButton() {
        driver.findElement(okButton).click();
    }
}
