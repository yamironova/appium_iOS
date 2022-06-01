package pages;
// пакеты Селениума
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
public class MainPage {
    private IOSDriver  driver;
    public MainPage(IOSDriver driver) {
        this.driver = driver;
    }

    // Common locator
    private By socialIcon = By.xpath("//div[@class='social-icon svg-icon']");
    private By addTask = By.xpath("//div[@id='create-task-btn']");

    //Tag locator
    private By tagDrop= By.xpath("//button[span[text()='Теги']]");
    private By changeTagLink = By.xpath("//a[text()='Изменить теги']");
    private By newTagInput= By.xpath("//input[contains(@class, 'new-tag')]");
    private By saveLink = By.xpath("//a[text()='Сохранить изменения']");
    private By oneTagInput = By.xpath("(//input[contains(@class, 'tag-edit-input')])[last()]");
    private By oneTagView = By.xpath("//div[contains(@class, 'col-6')]");
    private By cancelTagLink = By.xpath("//a[text()='Отмена']");
    private By oneTagBasket = By.xpath("//div[contains(@class, 'svg-icon destroy-icon')]");


    public MainPage checkLoading() {
        //создадим ожидание для отдельных элементов на будущее
        WebDriverWait wait10 = (new WebDriverWait(driver, 10));
        // попробуем тупа задержку, потому что всё грузится по два раза
        wait10.until(ExpectedConditions.presenceOfElementLocated(socialIcon));
        // кнопку тоже подождём на всякий случай
        wait10.until(ExpectedConditions.presenceOfElementLocated(addTask ));
        return this;
    }

    // Tags methods

    public MainPage typeTagName(String name) {
        driver.findElement(newTagInput).sendKeys(name);
        driver.findElement(newTagInput).sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage createTag(String name) {
        driver.findElement(tagDrop).click();
        driver.findElement(changeTagLink).click();
        typeTagName(name);
        driver.findElement(saveLink).click();
        driver.findElement(cancelTagLink).click();
        return new MainPage(driver);
    }

    public int countTag() {
        driver.findElement(tagDrop).click();
        int n = driver.findElements(oneTagView).size();
        driver.findElement(cancelTagLink).click();
        return n;

    }

    public MainPage deleteTag() throws IOException {


        driver.findElement(tagDrop).click();
        driver.findElement(changeTagLink).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(oneTagInput)).build().perform();

        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('svg-icon destroy-icon')[0].click();");

        driver.findElement(saveLink).click();
        driver.findElement(cancelTagLink).click();
        return new MainPage(driver);
    }
}
