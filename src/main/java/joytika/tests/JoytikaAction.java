package joytika.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by NasyaS on 03.12.2015.
 */
public class JoytikaAction {

    static WebDriver driver = new FirefoxDriver();

    // driver.get("http://www.joytika.com");
    protected static void init() {

    }

    static void tutorClickButton() {
        WebElement element = driver.findElement(By.xpath(JoytikaXpath.tutorButton));
        element.click();
    }

    static void tutorClickCross() {
        WebElement cross = driver.findElement(By.xpath(JoytikaXpath.cross));
        cross.click();
    }

    static void openMenu() {
        WebElement menu = driver.findElement(By.xpath(JoytikaXpath.leftmenu));
        menu.click();
    }

    static void myAccountClick() {
        WebElement myaccount = driver.findElement(By.xpath(JoytikaXpath.Menu.myaccount));
        myaccount.click();
    }

    static void login(String vkName, String vkPassword) {

        WebDriverWait wait = new WebDriverWait(driver, 300);

        JoytikaAction.openMenu();
        JoytikaAction.myAccountClick();

        WebElement loginButton = driver.findElement(By.xpath(JoytikaXpath.LoginWindow.loginButton));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JoytikaXpath.LoginWindow.loginBox)));
        WebElement vkLoginField = driver.findElement(By.xpath(JoytikaXpath.LoginWindow.vkLoginField));
        vkLoginField.sendKeys(vkName);

        WebElement vkPasswordField = driver.findElement(By.xpath(JoytikaXpath.LoginWindow.vkPasswordField));
        vkPasswordField.sendKeys(vkPassword);

        WebElement vkLoginButton = driver.findElement(By.xpath(JoytikaXpath.LoginWindow.vkLoginButton));
        vkLoginButton.click();

    }

}
