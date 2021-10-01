package guru.qa;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("������� ������� ��������")
    public static void openMainPage() {
        open("/");
    }

    @Step("����� ����������� {repo}")
    public static void searchForRepository(String repo) {
        $(byName("q")).setValue(repo).pressEnter();
    }

    @Step("������� � ����������� {repository}")
    public static void openRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("��������� ������� Issues")
    public static void openIssues() {
        $("#issues-tab").click();
    }

    @Step("��������� ������� � Issue � ������� {number} ����� {name}")
    public static void issueShouldHaveCorrectName(int number, String name) {
        $(withText("#" + number)).
                parent().parent().shouldHave(text(name));
    }
}