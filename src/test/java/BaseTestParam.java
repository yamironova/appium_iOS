import drivers.AndroidStudioEmu;
import drivers.GenimotionEmu;
import drivers.WiFiReal;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ClockPage;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTestParam {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPage clockPage1;

    @ParameterizedTest
   // @ValueSource(strings = {"Emu", "Studio", "Real"})
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
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
