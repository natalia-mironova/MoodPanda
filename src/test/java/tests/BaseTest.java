package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.MoodSteps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    MoodSteps steps;

    @BeforeClass
    public void setupBrowser() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
    }

    @BeforeMethod
    public void openBrowser() {
        steps = new MoodSteps();

    }

//    @AfterClass
//    public void ttt(){
//
//    }

    @AfterMethod
    public void closeBrowser() {
        getWebDriver().close();

    }

}
