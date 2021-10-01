package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWindow;
import static guru.qa.TestData.*;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = BASE_URL;
        Configuration.timeout = 7500;
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}