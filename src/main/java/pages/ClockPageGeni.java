package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClockPageGeni {
    private AppiumDriver driver;

    public ClockPageGeni(AppiumDriver driver) { this.driver = driver; }

    private By alarm = By.xpath("//android.widget.TextView[@text='CLOCK']");
    private By clock = By.xpath("//android.widget.TextView[@text='ALARM']");
    private By timer = By.xpath("//android.widget.TextView[@text='TIMER']");
    private By stopwatch = By.xpath("//android.widget.TextView[@text='STOPWATCH']");

    public void someClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(alarm).click();
        driver.findElement(clock).click();
        driver.findElement(timer).click();
        driver.findElement(stopwatch).click();
    }

}
