package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.TestData.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends TestBase{

    @Test
    public void issueHasCorrectNameTest() {
        step("������� ������� ��������", () -> {
                    open("/");
                });
        step("����� ����������� " + REPOSITORY, () -> {
            $(byName("q")).setValue(REPOSITORY).pressEnter();
        });
        step("������� ����������� " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("������� Issues", () -> {
            $("#issues-tab").click();
        });
        step(String.format("���������, ��� � Issue � ������� %d �������� ����� - %s", ISSUE_NUMBER, ISSUE_NAME), () -> {
            $(withText("# " + ISSUE_NUMBER)).
                    parent().parent().shouldHave(text(ISSUE_NAME));
        });
    }

}
