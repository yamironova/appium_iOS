package pages;
// пакеты Селениума
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;





public class HomePage {
    private IOSDriver  driver;

    public HomePage(IOSDriver  driver) {
        this.driver = driver;
    }

    private By mainText = By.xpath("//h1");
    private By singIn = By.xpath("//a[contains(@class, \'login-button\')]");
    private By socialIcon = By.xpath("//div[@class='social-icon svg-icon']");

    public HomePage checkLoading() {

        //создадим ожидание для отдельных элементов на будущее
        WebDriverWait wait10 = (new WebDriverWait(driver, 10));
        // попробуем тупа задержку, потому что всё грузится по два раза

        // ждём цитаты - они грузятся последние
        wait10.until(ExpectedConditions.presenceOfElementLocated(socialIcon));
        // кнопку тоже подождём на всякий случай
        wait10.until(ExpectedConditions.presenceOfElementLocated(singIn));


        return this;
    }



    public String readMainText() {
        String text;
        text=driver.findElement(mainText).getText();
        return text;
    }


    public LoginPage clickOnSingIn() {
        driver.findElement(singIn).click();
        return new LoginPage(driver);
    }

  
}
