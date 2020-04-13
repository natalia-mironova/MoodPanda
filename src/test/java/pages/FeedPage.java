package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    String UPDATE_MOOD_ID = "#LinkUpdate";

    public FeedPage isOpened() {
        $("#LinkUpdate").waitUntil(Condition.visible, 30000);
        // or
        // $("#LinkUpdate").shouldBe(Condition.visible);
        return this;
    }

    public MoodModal clickUpdate() {
        $(UPDATE_MOOD_ID).click();
        return new MoodModal();
    }
}
