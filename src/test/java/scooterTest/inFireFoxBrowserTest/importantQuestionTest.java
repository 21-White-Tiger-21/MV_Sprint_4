package scooterTest.inFireFoxBrowserTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.homePage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class importantQuestionTest extends connectionFireFox {

    private static int listIndex;

    //конструктор тест-класса "Вопросы о важном" с 2 параметрами
    public importantQuestionTest(int listIndex) {
        importantQuestionTest.listIndex =listIndex;
    }

    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
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
        homePage objHomePage = new homePage(driver);

        //открывает главную страницу
        objHomePage.openScooterPage();

        //кликаю по кнопке с вопросами, в зависимости от индекса
        objHomePage.clickButtonsImportantQuestions(listIndex);

        //сравнивает результаты
        assertTrue(objHomePage.contentIsDisplayed(listIndex));
    }

}
