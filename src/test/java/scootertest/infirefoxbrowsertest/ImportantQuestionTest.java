package scootertest.infirefoxbrowsertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ImportantQuestionTest extends ConnectionFireFox {
    private static int listIndex;

    //конструктор тест-класса "Вопросы о важном" с 2 параметрами
    public ImportantQuestionTest(int listIndex) {
        ImportantQuestionTest.listIndex = listIndex;
    }

    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    @Test
    public void IsVisibleTextWhenClickedButton() {
        //создет объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        //открывает главную страницу
        objMainPage.openScooterPage();
        //кликаю по кнопке с вопросами, в зависимости от индекса
        objMainPage.clickButtonsImportantQuestions(listIndex);
        //сравнивает результаты
        assertTrue(objMainPage.contentIsDisplayed(listIndex));
    }
}
