import drivers.GenimotionEmu;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ClockPageGeni;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class ClockGeniTest {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPageGeni clockPage1;


    @BeforeEach
    public void createDriver() throws MalformedURLException {
       driver = GenimotionEmu.setGenEmu();

    }

    @Test
    public void calApp() throws MalformedURLException {

      clockPage1 = new ClockPageGeni(driver);
      clockPage1.someClick();

        log.info("5. quit");

    }

    @AfterEach()
    public void closeDriver() {
        driver.quit();
    }

}
