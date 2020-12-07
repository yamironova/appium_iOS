import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class ClockTest {
    private static AppiumDriver driver;

    @BeforeAll
    static void createDriver() throws MalformedURLException {

        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        // через генимоушен (android 9)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.205.101:5555");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        // через реальное устройство (android 10)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2a41c0c8610d7ece");

        // install app
        // capabilities.setCapability(MobileCapabilityType.APP,
        //     "G:/Codeart/automatization/Idea_projects/apk/APK.apk");

        // open app
        capabilities.setCapability("appPackage", "com.google.android.deskclock");
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");


        log.info("1. Create driver");

        driver = new AndroidDriver(serverUrl, capabilities);

    }

    @Test
    public void calApp() throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Clock']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Timer']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Stopwatch']")).click();

        log.info("5. quit");

    }

    @AfterAll()
    public void closeDriver() {
        driver.quit();
    }

}
