package pages;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClockPage {
    String device;
    private AppiumDriver driver;
    private By alarm, clock, timer, stopwatch;

    public ClockPage(String device, AppiumDriver driver) {
        this.device = device;
        this.driver = driver;

        if (device.equals("Studio")) {
            this.alarm = By.xpath("//android.widget.TextView[@text='Clock']");
            this.clock = By.xpath("//android.widget.TextView[@text='Alarm']");
            this.timer = By.xpath("//android.widget.TextView[@text='Timer']");
            this.stopwatch = By.xpath("//android.widget.TextView[@text='Stopwatch']");

        } else {
            if (device.equals("Real")) {
                this.alarm = By.xpath("//android.widget.TextView[@text='Будильник']");
                this.clock = By.xpath("//android.widget.TextView[@text='Мировое время']");
                this.timer = By.xpath("//android.widget.TextView[@text='Таймер']");
                this.stopwatch = By.xpath("//android.widget.TextView[@text='Секундомер']");

            }
            else { if (device.equals("Emu")) {
                this.alarm = By.xpath("//android.widget.TextView[@text='CLOCK']");
                this.clock = By.xpath("//android.widget.TextView[@text='ALARM']");
                this.timer = By.xpath("//android.widget.TextView[@text='TIMER']");
                this.stopwatch = By.xpath("//android.widget.TextView[@text='STOPWATCH']");

            }

            }
        }

    }



    public void someClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(alarm).click();
        driver.findElement(clock).click();
        driver.findElement(timer).click();
        driver.findElement(stopwatch).click();
    }
}
