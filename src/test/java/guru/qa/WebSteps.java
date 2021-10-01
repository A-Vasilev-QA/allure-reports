package guru.qa;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открыть главную страницу")
    public static void openMainPage() {
        open("/");
    }

    @Step("Найти репозиторий {repo}")
    public static void searchForRepository(String repo) {
        $(byName("q")).setValue(repo).pressEnter();
    }

    @Step("Перейти в репозиторий {repository}")
    public static void openRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Открывыть разедел Issues")
    public static void openIssues() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие у Issue с номером {number} имени {name}")
    public static void issueShouldHaveCorrectName(int number, String name) {
        $(withText("#" + number)).
                parent().parent().shouldHave(text(name));
    }
}