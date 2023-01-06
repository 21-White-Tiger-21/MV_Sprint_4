package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



//класс главной страницы сайта самокат
public class homePage {
    private final WebDriver driver;

    public homePage(WebDriver driver) {

        this.driver=driver;
    }

    //открывает главную страницу самоката
    public void openScooterPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //скроллит страницу и кликает по кнопке в разделе "Вопросы о важном"
    public void clickButtonsImportantQuestions(int listIndex) {
        By locator= buttonsImportantQuestionsArray[listIndex];
        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , element);

        //неявное ожидание в 5 секунд для визуального понимания
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    //локатор для верхней кнопки "Заказать"
    private final By higherOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");

    //локатор для нижней кнопки "Заказать"
    private final By lowerOrderButton = By.className("Button_Middle__1CSJM");

    //кликает по верхней кнопке "Заказать" на главной странице
    public void higherOrderButtonClick() {

        driver.findElement(higherOrderButton).click();

    }

    //кликает по нижней кнопке "Заказать"
    public void lowerOrderButtonClick() {
        WebElement element=driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , element);
        driver.findElement(lowerOrderButton).click();
    }

    //выбор кнопки "Заказать" на странице
    public void chooseOrderButtonAndClick(String buttonLocation) {
        if (buttonLocation.equals("up")) {
            higherOrderButtonClick();
        } else if (buttonLocation.equals("down")) {
            lowerOrderButtonClick();
        }
    }

    //локаторы кнопкок вопросов раздела "Вопросы о важном"

    //кнопка "Сколько это стоит? И как оплатить?"
    private final By buttonsImportantQuestionsList_0 = By.id("accordion__heading-0");

    //кнопка "Хочу сразу несколько самокатов! Так можно?"
    private final By buttonsImportantQuestionsList_1 = By.id("accordion__heading-1");

    //кнопка "Как рассчитывается время аренды?"
    private final By buttonsImportantQuestionsList_2 = By.id("accordion__heading-2");

    //кнопка "Можно ли заказать самокат прямо на сегодня?"
    private final By buttonsImportantQuestionsList_3 = By.id("accordion__heading-3");

    //кнопка "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By buttonsImportantQuestionsList_4 = By.id("accordion__heading-4");

    //кнопка "Вы привозите зарядку вместе с самокатом?"
    private final By buttonsImportantQuestionsList_5 = By.id("accordion__heading-5");

    //кнопка "Можно ли отменить заказ?"
    private final By buttonsImportantQuestionsList_6 = By.id("accordion__heading-6");

    //кнопка "Я жизу за МКАДом, привезёте?"
    private final By buttonsImportantQuestionsList_7 = By.id("accordion__heading-7");

    //массив из локаторов кнопок раздела "Вопрсоы о важном"
    private final By[] buttonsImportantQuestionsArray = {buttonsImportantQuestionsList_0, buttonsImportantQuestionsList_1, buttonsImportantQuestionsList_2, buttonsImportantQuestionsList_3, buttonsImportantQuestionsList_4, buttonsImportantQuestionsList_5, buttonsImportantQuestionsList_6, buttonsImportantQuestionsList_7};

    //локаторы к текстовым ответам раздела "Вопросы о важном"

    //текст ответа на вопрос "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
    private final By answersImportantQuestionsList_0 = By.xpath(".//div[@id='accordion__panel-0']/p");

    //текст ответа на вопрос "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
    private final By answersImportantQuestionsList_1 = By.xpath(".//div[@id='accordion__panel-1']/p");

    //текст ответа на вопрос "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
    private final By answersImportantQuestionsList_2 = By.xpath(".//div[@id='accordion__panel-2']/p");

    //текст ответа на вопрос "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    private final By answersImportantQuestionsList_3 = By.xpath(".//div[@id='accordion__panel-3']/p");

    //текст ответа на вопрос "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
    private final By answersImportantQuestionsList_4 = By.xpath(".//div[@id='accordion__panel-4']/p");

    //текст ответа на вопрос "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
    private final By answersImportantQuestionsList_5 = By.xpath(".//div[@id='accordion__panel-5']/p");

    //текст ответа на вопрос "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    private final By answersImportantQuestionsList_6 = By.xpath(".//div[@id='accordion__panel-6']/p");

    //текст ответа на вопрос "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    private final By answersImportantQuestionsList_7 = By.xpath(".//div[@id='accordion__panel-7']/p");

    //массив локаторов из текстовых ответов на вопрос раздела "Вопрсоы о важном"
    private final By[] answersImportantQuestionsArray = {answersImportantQuestionsList_0, answersImportantQuestionsList_1, answersImportantQuestionsList_2, answersImportantQuestionsList_3, answersImportantQuestionsList_4, answersImportantQuestionsList_5, answersImportantQuestionsList_6, answersImportantQuestionsList_7};

    //массив ожидаемых ответов к вопросам
    private final String[] expectedAnswersImportantQuestions = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };


    //метод для получения контента из текстовых ответов раздела "Вопрсоы о важном"
    public String getAnswersImportantQuestions(int listIndex){
        By locator = answersImportantQuestionsArray[listIndex];
        return driver.findElement(locator).getText();
    }

    //метод для сравнения текстовых ответов с ожидаемыми ответами
    public boolean contentIsDisplayed (int listIndex) {
        By locator = answersImportantQuestionsArray[listIndex];
        String expectedAnswersText = expectedAnswersImportantQuestions[listIndex];

        //неявное ожидание в 5 секунд для визуального понимания (быстро прокликивает и некоторые не успевает проверить)
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed() && getAnswersImportantQuestions(listIndex).equals(expectedAnswersText);
    }
}
