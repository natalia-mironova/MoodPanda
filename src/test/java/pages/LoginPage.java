package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    String URL = "https://moodpanda.com/Login/";

    public LoginPage openPage() {
        open(URL);
        //дожидаемся что загрузились все элементы
        $("[alt='MoodPanda Android App on Google Play']").waitUntil(Condition.visible, 30000);
        return this;
    }

    public LoginPage login(String user, String password) {
        sleep(3000);
        $(By.id("ContentPlaceHolderContent_TextBoxEmail")).setValue(user);
        sleep(5000);
        $(By.id("ContentPlaceHolderContent_TextBoxPassword")).setValue(password);
        sleep(5000);
        $(By.id("ContentPlaceHolderContent_ButtonLogin")).click();
        sleep(5000);
        return this;
    }

}
