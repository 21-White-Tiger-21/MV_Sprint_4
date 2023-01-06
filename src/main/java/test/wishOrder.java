package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//класс страницы "Хотите оформить заказ?"
public class wishOrder {
    private final WebDriver driver;

    public wishOrder(WebDriver driver) {

        this.driver=driver;
    }

    //Кнопка "Да" в всплывающем окне "Хотите оформить заказ?"
    private final By okButton = By.xpath(".//*[text()='Да']");

    //метод для нажатия на кнопку "Да"
    public void clickOkButton(){

        driver.findElement(okButton).click();
    }
}
