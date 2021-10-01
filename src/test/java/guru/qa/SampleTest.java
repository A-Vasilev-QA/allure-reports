package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.TestData.*;

public class SampleTest extends TestBase {
    @Test
    public void issueHasCorrectNameTest() {
        open("/");
        $(byName("q")).setValue(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE_NUMBER)).parent().parent().shouldHave(text(ISSUE_NAME));
    }
}
