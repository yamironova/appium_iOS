import io.appium.java_client.ios.*;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;

@Log4j2

public class AppTest {

    @Test
    public void testApp() throws IOException {


        DesiredCapabilities cap = new DesiredCapabilities();
  
        cap.setCapability("platformName", "iOS");
        cap.setCapability("platformVersion", "15.5");
        cap.setCapability("deviceName", "iPhone 11");
        cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
        //cap.setCapability("app", “/Users/mac/Desktop/iOS_emu/SandBox/Yulia_test_sandbox/build/Release-iphonesimulator/Yulia_test_sandbox.app“);
 
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
  
        IOSDriver driver = new IOSDriver(url, cap);


        driver.quit();
    }
}
