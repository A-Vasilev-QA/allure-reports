package guru.qa;

import org.junit.jupiter.api.Test;

import static guru.qa.TestData.*;
import static guru.qa.WebSteps.*;

public class AnnotatedStepTest extends TestBase{

    @Test
    public void issueHasCorrectNameTest(){
        openMainPage();
        searchForRepository(REPOSITORY);
        openRepository(REPOSITORY);
        openIssues();
        issueShouldHaveCorrectName(ISSUE_NUMBER, ISSUE_NAME);
    }
}
