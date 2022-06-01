import io.appium.java_client.ios.IOSDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import drivers.IOSEmu;
import java.io.IOException;

import static config.EnvConfig.URL_BASE;;


public class BrowserTest {

    @Test
    public void testLogin() throws IOException {
        HomePage homePage1;
        LoginPage loginPage1;
        MainPage mainPage1;

        IOSDriver driver = IOSEmu.runApp();
     
        driver.get(URL_BASE);
        homePage1 = new HomePage(driver);
        homePage1.checkLoading();

        loginPage1 = homePage1.clickOnSingIn();
        loginPage1.checkLoading();

        mainPage1 = loginPage1.login();
        mainPage1.checkLoading();
  
        driver.quit();
    }
    @AfterEach public void closeDrive() {
            

    }
}
