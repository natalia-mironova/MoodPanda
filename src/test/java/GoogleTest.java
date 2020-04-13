import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GoogleTest {

    @Test
    public void searchInGoogle() {
        // можно задать другой браузер. по дефолту firefox
        Configuration.browser = "chrome";

        // implicitWait:
        Configuration.timeout = 10000;

        //все клики через js
        //Configuration.clickViaJs;

        //headless
        //Configuration.headless = true;

        open("https://www.google.com/");
        $(By.name("q")).sendKeys("TeachMeSkills");
        $(By.name("btnK")).click();
        // $без ничего - по css selector по дефолту. Если By. - по любому локатору
        // $(By.name("q")).waitUntil(Condition.visible, 30000); можно так добавлять wait
        // можно работать с List
        // List<SelenideElement> list = $$("");

        // по xpath:
        // $(byText("Sign in")).click();

        // should have example:
        //$(By.name("btnK")).shouldHave(Condition.text("here text"));

        // добавить sleep (плохое решение, но можно)
        sleep(10000);

        //to close browser:
        getWebDriver().close();


    }
}
