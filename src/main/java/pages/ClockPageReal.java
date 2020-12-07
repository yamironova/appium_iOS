package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClockPageReal {
    private AppiumDriver driver;

    public ClockPageReal(AppiumDriver driver) { this.driver = driver; }

    private By alarm = By.xpath("//android.widget.TextView[@text='Будильник']");
    private By clock = By.xpath("//android.widget.TextView[@text='Мировое время']");
    private By timer = By.xpath("//android.widget.TextView[@text='Таймер']");
    private By stopwatch = By.xpath("//android.widget.TextView[@text='Секундомер']");

    public void someClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(alarm).click();
       // driver.findElement(clock).click();
        driver.findElement(timer).click();
        driver.findElement(stopwatch).click();
    }

}
