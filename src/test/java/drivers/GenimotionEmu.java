package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class GenimotionEmu {

    public static AppiumDriver setGenEmu() throws MalformedURLException {
        AppiumDriver driver ;
        URL serverUrl;
        DesiredCapabilities capabilities;
        serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.205.101:5555");
        // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        // через реальное устройство (android 10)
        // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2a41c0c8610d7ece");

        // install app
        // capabilities.setCapability(MobileCapabilityType.APP,
        //     "G:/Codeart/automatization/Idea_projects/apk/APK.apk");

        // open app
        capabilities.setCapability("appPackage", "com.android.deskclock");
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

        driver = new AndroidDriver(serverUrl, capabilities);

        return driver;
    }

}
