import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static helper.MakeScreen.makeScreenShot;

@Log4j2

public class BrowserTest {

    @Test
    public void testLogin() throws IOException {

        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
       // через генимоушен (android 9)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.205.101:5555");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        // через реальный телефон (android 10)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2a41c0c8610d7ece");
        // add app
        // capabilities.setCapability(MobileCapabilityType.APP, "G:/Codeart/automatization/Idea_projects/apk/Sol.apk");
        HomePage homePage1;
        LoginPage loginPage1;
        MainPage mainPage1;


        log.info("1. Create driver");

        AppiumDriver driver = new AndroidDriver(serverUrl, capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        log.info("2. Open site");
        driver.get("https://habitica.com");
        homePage1 = new HomePage(driver);
        homePage1.checkLoading();


        log.info("3. Enter email and pass");
        loginPage1 = homePage1.clickOnSingIn();
        loginPage1.checkLoading();
        log.info("Open Login Page");
        makeScreenShot(driver);


        log.info("4. Click login");
        mainPage1 = loginPage1.login();
        log.info("Login");


        //mainPage1.checkLoading();
        log.info("5. Check");
        // makeScreenShot(driver);
        driver.quit();
    }
    @AfterEach public void closeDrive() {
            log.info("6. Close driver");

    }
}
