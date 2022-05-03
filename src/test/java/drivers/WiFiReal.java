package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WiFiReal {

    public static AppiumDriver setReal() throws MalformedURLException {
        AppiumDriver driver ;
        URL serverUrl;
        DesiredCapabilities capabilities;
        serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.0.89:4777");
        // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        // open app
        capabilities.setCapability("appPackage", "com.sec.android.app.clockpackage");
        capabilities.setCapability("appActivity", "com.sec.android.app.clockpackage.ClockPackage");
        driver = new AndroidDriver(serverUrl, capabilities);

        return driver;
    }
}
