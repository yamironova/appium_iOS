import drivers.AndroidStudioEmu;
import drivers.GenimotionEmu;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ClockPageASEmu;
import pages.ClockPageGeni;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class ClockASEmuTest {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPageASEmu clockPage1;


    @BeforeEach
    public void createDriver() throws MalformedURLException {
       driver = AndroidStudioEmu.setASEmu();

    }

    @Test
    public void calApp() throws MalformedURLException {

      clockPage1 = new ClockPageASEmu(driver);
      clockPage1.someClick();

        log.info("5. quit");

    }

    @AfterEach()
    public void closeDriver() {
        driver.quit();
    }

}
