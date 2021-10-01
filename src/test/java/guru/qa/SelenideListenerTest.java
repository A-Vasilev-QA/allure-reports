package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static guru.qa.TestData.*;


public class SelenideListenerTest extends TestBase{

    @Test
    public void issueHasCorrectNameTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $(byName("q")).as("Строка поиска").setValue(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).as("Ссылка репозитория").click();
        $("#issues-tab").as("Список Issues").click();
        $(withText("#" + ISSUE_NUMBER)).as("Issue с номером" + ISSUE_NUMBER)
                .parent().parent().as("Заголовок Issue").shouldHave(text(ISSUE_NAME));
    }
}
