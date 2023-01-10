package scootertest.inchromebrowsertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderStatusTest extends ConnectionChrome {
    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;

    //конструктор тест-класса
    public OrderStatusTest(String buttonLocation, String name, String surname, String address, String telephone, String newDate, int days, String newColor, String newComment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.newDate = newDate;
        this.days = days;
        this.newColor = newColor;
        this.newComment = newComment;
    }

    //тестовые данные
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"up", "Виталий", "Матвеев", "Новокузнецкая", "89996481874", "06.01.2023", 1, "black", "Сам выйду за самокатом"},
                {"down", "Алексей", "Рукавишников", "Орехово", "89049664208", "02.01.2023", 5, "grey", "Можно проверить перед принятием аренды"},
        };
    }

    @Test
    public void enterOrderAllDataTest() {
        //создет объект главной страницы
        MainPage objMainPage = new MainPage(driver);
        //обращается к сайту Самоката
        objMainPage.openScooterPage();
        //выбирает кнопку "Заказать" для клика
        objMainPage.chooseOrderButtonAndClick(buttonLocation);
        //создает объект страницы "Для кого самокат"
        new OrderDataPage(driver)
                //вызывает метод для ввода данных на странице "Для кого самокат"
                .enterOrderAllData(name, surname, address, telephone);
        //создает объект страницы "Про аренду"
        new RentOrderPage(driver)
                //вызывает метод для ввода данных на странице "Про аренду"
                .enterAllDataRentOrder(newDate, days, newColor, newComment);
        //создает объект всплывающего окна "Хотите оформить заказ?"
        new WindowOrderIsOk(driver)
                //нажимает кнопку "Да" в всплывающем окне "Хотите оформить заказ?"
                .clickOkButton();
        //создает всплывающего окна "Заказ оформлен"
        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        //проверяет, что всплывающее окно "Заказ оформлен" отображается
        assertTrue(objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }
}
