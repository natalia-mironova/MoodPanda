package steps;

import io.qameta.allure.Step;
import pages.FeedPage;
import pages.LoginPage;
import pages.MoodModal;

public class MoodSteps {
    LoginPage loginPage;
    FeedPage feedPage;
    MoodModal moodModal;

    public MoodSteps() {
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        moodModal = new MoodModal();
    }

    @Step("Step 1: User loggs in into the account")
    public MoodSteps login(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
        feedPage.isOpened();
        return this;
    }

    @Step("Step 2: User updates the Mood")
    public MoodSteps updateMood(int moodRating, String description, String date) {
        feedPage.clickUpdate();
        moodModal.isPageOpened();
        moodModal.updateDetails(moodRating, description, date);
        moodModal.clickUpdateMood();
        moodModal.toDiary();
        feedPage.isOpened();
        return this;
    }

}
