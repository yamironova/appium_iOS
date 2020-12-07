package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClockPageASEmu {
    private AppiumDriver driver;

    public ClockPageASEmu(AppiumDriver driver) { this.driver = driver; }

    private By alarm = By.xpath("//android.widget.TextView[@text='Clock']");
    private By clock = By.xpath("//android.widget.TextView[@text='Alarm']");
    private By timer = By.xpath("//android.widget.TextView[@text='Timer']");
    private By stopwatch = By.xpath("//android.widget.TextView[@text='Stopwatch']");

    public void someClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(alarm).click();
        driver.findElement(clock).click();
        driver.findElement(timer).click();
        driver.findElement(stopwatch).click();
    }

}
