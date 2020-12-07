import drivers.GenimotionEmu;
import drivers.WiFiReal;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ClockPageGeni;
import pages.ClockPageReal;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class ClockRealTest {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPageReal clockPage1;


    @BeforeEach
    public void createDriver() throws MalformedURLException {
       driver = WiFiReal.setReal();

    }

    @Test
    public void calApp() throws MalformedURLException {

      clockPage1 = new ClockPageReal(driver);
      clockPage1.someClick();

        log.info("5. quit");

    }

    @AfterEach()
    public void closeDriver() {
        driver.quit();
    }

}
