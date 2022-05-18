import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class PresenceOfCode {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkForCode(){

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("div.markdown-body").$(byText("Chapters")).closest("div").$("ul").shouldHave(Condition.text("Soft assertions"));
        $("div.markdown-body").$(byText("Chapters")).closest("div").$("ul").$(byText("Soft assertions")).click();
        $("body").shouldHave(Condition.text("Using JUnit5"));

    }

}


