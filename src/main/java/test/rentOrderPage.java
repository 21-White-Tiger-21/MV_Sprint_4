package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


//класс страницы "Про аренду"
public class rentOrderPage {
    private final WebDriver driver;

    public rentOrderPage(WebDriver driver) {

        this.driver = driver;
    }

    //локатор для выпадающего списка "Когда привезти самокат"
    private final By orderDataWhenDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //локатор для поля "Срок аренды"
    private final By rentalPeriod = By.className("Dropdown-placeholder");

    //локатор для поля "Срок аренды - сутки"
    private final By period_1day = By.xpath(".//*[@class='Dropdown-option'][1]");

    //локатор для поля "Срок аренды - 2 суток"
    private final By period_2days = By.xpath(".//*[@class='Dropdown-option'][2]");

    //локатор для поля "Срок аренды - 3 суток"
    private final By period_3days = By.xpath(".//*[@class='Dropdown-option'][3]");

    //локатор для поля "Срок аренды - 4 суток"
    private final By period_4days = By.xpath(".//*[@class='Dropdown-option'][4]");

    //локатор для поля "Срок аренды - 5 суток"
    private final By period_5days = By.xpath(".//*[@class='Dropdown-option'][5]");

    //локатор для поля "Срок аренды - 6 суток"
    private final By period_6days = By.xpath(".//*[@class='Dropdown-option'][6]");

    //локатор для поля "Срок аренды - 7 суток"
    private final By period_7days = By.xpath(".//*[@class='Dropdown-option'][7]");

    //цвет самоката "Церный жемчуг"
    private final By blackPearl = By.xpath(".//input[@id='black']");

    //цвет самоката "Серая безысходность"
    private final By grayHopelessness = By.xpath(".//input[@id='grey']");

    //поле "Комментарий" для курьера
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //метод для выбора даты в выпадающем списке "Когда привезти самокат"
    public void enterDate(String newDate) {
        driver.findElement(orderDataWhenDelivery).sendKeys(newDate);
        driver.findElement(orderDataWhenDelivery).sendKeys(Keys.ENTER);
    }
    //метод для выбора значения в выпадающем списке "Срок аренды"
    public void choosePeriod(int days) {

        //выбор значения "сутки" из выпадающего списка "Срок аренды"
        driver.findElement(rentalPeriod).click();
        if (days==1) {
            driver.findElement(period_1day).click();

            //выбор значения "двое суток" из выпадающего списка "Срок аренды"
        } else if (days==2) {
            driver.findElement(period_2days).click();

            //выбор значения "трое суток" из выпадающего списка "Срок аренды"
        } else if (days==3) {
            driver.findElement(period_3days).click();

            //выбор значения "четверо суток" из выпадающего списка "Срок аренды"
        } else if (days==4) {
            driver.findElement(period_4days).click();

            //выбор значения "пятеро суток" из выпадающего списка "Срок аренды"
        } else if (days==5) {
            driver.findElement(period_5days).click();

            //выбор значения "шестеро суток" из выпадающего списка "Срок аренды"
        } else if (days==6) {
            driver.findElement(period_6days).click();

            //выбор значения "семеро суток" из выпадающего списка "Срок аренды"
        } else if (days==7) {
            driver.findElement(period_7days).click();
        }
    }

    //выбор цвета самоката "Церный жемчуг"
    public void clickBlackPearl() {

        driver.findElement(blackPearl).click();
    }

    //выбор цвета самоката "Серая безысходность"
    public void clickGrayHopelessness() {
        driver.findElement(grayHopelessness).click();
    }

    //метод выбора цвета
    public void chooseColor(String newColor) {
        //выбор цвета "Церный жемчуг"
        if (newColor.equals("black")) {
            clickBlackPearl();
            //выбор цвета "Серая безысходность"
        } else if (newColor.equals("grey")) {
            clickGrayHopelessness();
        }
    }

    //метод для ввода комментария для курьера
    public void enterComment(String newComment) {

        driver.findElement(comment).sendKeys(newComment);
    }

    //метод для нажатия кнопки "Заказать"
    public void clickOrderButton() {

        driver.findElement(orderButton).click();
    }

    //общий метод для ввода "Даты", выбора периода, выбора "Цвета", ввода "комментария" и нажатия на кнопку "Заказать" на странице "Про аренду"
    public void enterAllDataRentOrder(String newDate, int days, String newColor, String newComment){
        enterDate(newDate);
        choosePeriod(days);
        chooseColor(newColor);
        enterComment(newComment);
        new WebDriverWait(driver, 3);
        clickOrderButton();
    }
}