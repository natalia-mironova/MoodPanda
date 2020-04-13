package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class MoodTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL) //Severity for Allure Report
    @Test(description = "User loggs in and updates Mood", priority = 1)
    @Description("Check if user is able to update the Mood")
    @Link("https://moodpanda.com/Feed/") //Link
    @Issue("linkToBugReport")
    @TmsLink("linkToTestCaseInTmsSystem")
    public void updateMoodTest() {
        steps
                .login("natalia16@mailinator.com", "admin123")
                .updateMood(8, "test new description", "2 days ago");
    }
}
