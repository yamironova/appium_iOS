package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.EnvConfig.LOGIN;
import static config.EnvConfig.PASSWORD;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By gryphonIcon = By.xpath("//div[@class='svg-icon gryphon']");
    private By emailField = By.xpath("//input[@id='usernameInput']");
    private By passwordField = By.xpath("//input[@id='passwordInput']");



    public LoginPage checkLoading() {

        //создадим ожидание для отдельных элементов на будущее
        WebDriverWait wait10 = (new WebDriverWait(driver, 10));
        // попробуем тупа задержку, потому что всё грузится по два раза
        wait10.until(ExpectedConditions.presenceOfElementLocated(gryphonIcon));
        // кнопку тоже подождём на всякий случай
        wait10.until(ExpectedConditions.presenceOfElementLocated(buttonLogin));

        return this;
    }

    public LoginPage typeEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
        return this;
    }
    public LoginPage typePassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
        return this;
    }

    public MainPage login() {
        this.typeEmail(LOGIN);
        this.typePassword(PASSWORD);
        WebDriverWait wait10 = (new WebDriverWait(driver, 10));
        // попробуем тупа задержку, потому что всё грузится по два раза

        // ждём цитаты - они грузятся последние
        wait10.until(ExpectedConditions.presenceOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
        return new MainPage(driver);

    }
}
