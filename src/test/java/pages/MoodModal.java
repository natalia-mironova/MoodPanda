package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.Keys.ARROW_LEFT;
import static org.openqa.selenium.Keys.ARROW_RIGHT;

public class MoodModal {

    String UPDATE_BUTTON_CSS = ".ButtonUpdate";
    String MY_DIARY_BUTTON_CSS = ".ButtonMyDiary";
    WebElement SLIDER = $(By.cssSelector(".ui-slider-handle"));

    public MoodModal isPageOpened() {
        $(UPDATE_BUTTON_CSS).should(Condition.appear);
        return this;
    }

    public MoodModal updateDetails(int moodRating, String description, String date) {
        SLIDER.click();
        if ((moodRating - 5) > 0) {
            for (int i = 5; i < moodRating; i++) {
                SLIDER.sendKeys(ARROW_RIGHT);
            }
        } else {
            for (int i = 5; i > moodRating; i--) {
                SLIDER.sendKeys(ARROW_LEFT);
            }
        }

        $("#TextBoxUpdateMoodTag").setValue(description);
        //sendKeys does the same

        if (date == "Older") {
            $(By.xpath("//*[@id='Advanced']/div/div[contains(text(),'Older')]")).click();
        } else if (date == "3 days ago") {
            $(By.xpath("//*[@id='Advanced']/div/div[contains(text(),'3 days ago')]")).click();
        } else if (date == "2 days ago") {
            $(By.xpath("//*[@id='Advanced']/div/div[contains(text(),'2 days ago')]")).click();
        } else if (date == "Yesterday") {
            $(By.xpath("//*[@id='Advanced']/div/div[contains(text(),'Yesterday')]")).click();
        } else
            $(By.xpath("//*[@id='Advanced']/div/div[contains(text(),'Now')]")).click();
        return this;
    }

    public MoodModal clickUpdateMood() {
        sleep(5000);
        $(UPDATE_BUTTON_CSS).click();
        return this;
    }

    public void toDiary() {
        $(MY_DIARY_BUTTON_CSS).click();

    }

}
