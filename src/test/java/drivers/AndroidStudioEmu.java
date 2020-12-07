package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidStudioEmu {

    public static AppiumDriver setASEmu() throws MalformedURLException {
        AppiumDriver driver ;
        URL serverUrl;
        DesiredCapabilities capabilities;
        serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        // open app
        capabilities.setCapability("appPackage", "com.google.android.deskclock");
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

        driver = new AndroidDriver(serverUrl, capabilities);

        return driver;
    }

}
