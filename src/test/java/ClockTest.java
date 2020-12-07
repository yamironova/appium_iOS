import drivers.AndroidStudioEmu;
import drivers.GenimotionEmu;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ClockPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class ClockTest {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPage clockPage1;


    @BeforeEach
    public void createDriver() throws MalformedURLException {
       // driver = AndroidStudioEmu.setASEmu();
        driver = GenimotionEmu.setGenEmu();

    }

    @Test
    public void calApp() throws MalformedURLException {

        clockPage1 = new ClockPage(driver);
        clockPage1.someClick();

        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Clock']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Timer']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Stopwatch']")).click();
*/

        log.info("5. quit");

    }

    @AfterEach()
    public void closeDriver() {
        driver.quit();
    }

}
