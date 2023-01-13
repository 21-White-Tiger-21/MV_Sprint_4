package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//Класс страницы Для кого самокат
public class OrderDataPage {
    private final WebDriver driver;
    //локатор для поля "Имя"
    private final By orderDataName = By.xpath("//input[@placeholder='* Имя']");
    //локатор для поля "Фамилия"
    private final By orderDataSurname = By.xpath("//input[@placeholder='* Фамилия']");
    //локатор для поля "Адрес: куда привезти заказ"
    private final By orderDataAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля "Станция метро"
    private final By orderDataSubwayStation = By.className("select-search__input");
    //локатор селектора "Станция метро"
    private final By orderSelectorSubwayStation = By.className("select-search__select");
    //локатор для поля "Телефон"
    private final By orderDataTelephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private final By orderButtonFurther = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для ввода "Имени"
    public void enterOrderDataName(String name) {
        driver.findElement(orderDataName).sendKeys(name);
    }

    //метод для ввода "Фамилии"
    public void enterOrderDataSurname(String surname) {
        driver.findElement(orderDataSurname).sendKeys(surname);
    }

    //метод для ввода "Адреса"
    public void enterOrderDataAddress(String address) {
        driver.findElement(orderDataAddress).sendKeys(address);
    }

    //метод обращения к полю "Станция метро" и выбора станции
    public void clickOrderDataSubwayStation() {
        driver.findElement(orderDataSubwayStation).click();
        driver.findElement(orderSelectorSubwayStation).isDisplayed();
        driver.findElement(orderDataSubwayStation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //метод для ввода номера "Телефона"
    public void enterOrderDataTelephone(String telephone) {
        driver.findElement(orderDataTelephone).sendKeys(telephone);

    }

    //кликает по кнопке "Далее" на старнице "Для кого самокат"
    public void clickOrderButtonFurther() {
        driver.findElement(orderButtonFurther).click();
    }

    //общий метод для ввода "Имени", "Фамилии", "Адреса", "Выбора станции", "Телефона", также кликает по кнопке "Далее"
    public void enterOrderAllData(String name, String surname, String address, String telephone) {
        enterOrderDataName(name);
        enterOrderDataSurname(surname);
        enterOrderDataAddress(address);
        clickOrderDataSubwayStation();
        enterOrderDataTelephone(telephone);
        clickOrderButtonFurther();
    }
}
