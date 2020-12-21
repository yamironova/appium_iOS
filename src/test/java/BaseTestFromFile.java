import drivers.AndroidStudioEmu;
import drivers.GenimotionEmu;
import drivers.WiFiReal;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ClockPage;
import pages.ClockPageASEmu;
import pages.ClockPageGeni;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTestFromFile {
    private AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;
    private ClockPage clockPage1;
    static InputStream input = null;
    public static Properties prop = new Properties();



    @BeforeEach
    public void createDriver() throws IOException {
        input = new FileInputStream("config/android.properties");
        prop.load(input);
        if (prop.getProperty("device").equals("Studio")) {
            driver = AndroidStudioEmu.setASEmu();;
        } else {
            if (prop.getProperty("device").equals("Real")) {
                driver = WiFiReal.setReal();
            }
            else { if (prop.getProperty("device").equals("Emu")) {
                driver = GenimotionEmu.setGenEmu();
                }

            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void calAppFromFile() throws MalformedURLException {

        clockPage1 = new ClockPage(prop.getProperty("device"), driver);
        clockPage1.someClick();

        log.info("5. quit");

    }

    @AfterEach()
    public void closeDriver() {
        driver.quit();
    }
}
