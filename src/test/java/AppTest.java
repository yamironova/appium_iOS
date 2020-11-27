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

public class AppTest {

    @Test
    public void testApp() throws IOException {

        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        // через генимоушен (android 9)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.205.101:5555");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        // через реальный телефон (android 10)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2a41c0c8610d7ece");
        // add app
        capabilities.setCapability(MobileCapabilityType.APP, "G:/Codeart/automatization/Idea_projects/apk/Sol.apk");



        log.info("1. Create driver");

        AppiumDriver driver = new AndroidDriver(serverUrl, capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 10);




        
        log.info("5. quit");

        driver.quit();
    }
}
