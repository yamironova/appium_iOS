import drivers.AndroidStudioEmu;
import drivers.GenimotionEmu;
import drivers.WiFiReal;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ClockPage;
import pages.ClockPageASEmu;
import pages.ClockPageGeni;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTestParam {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPage clockPage1;

    @ParameterizedTest
    @ValueSource(strings = {"Emu", "Studio", "Real"})
    public void runClock(String device) throws IOException {
        if (device.equals("Studio")) {
            driver = AndroidStudioEmu.setASEmu();;
        } else {
            if (device.equals("Real")) {
                driver = WiFiReal.setReal();
            }
            else { if (device.equals("Emu")) {
                driver = GenimotionEmu.setGenEmu();
            }

            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clockPage1 = new ClockPage(device, driver);
        clockPage1.someClick();

        log.info("5. quit");


    driver.quit(); }

}
