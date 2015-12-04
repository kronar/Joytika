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
   protected static void init () {

    }
    static void tutorClickButton(){
        WebElement element = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']"));
        element.click();
    }

    static void tutorClickCross() {
        WebElement cross = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-login _dota _active']/div[@id='blockLogin']/div[@class='block-tutor-inner']/div[@class='block-tutor-inner-close windowClose']"));
        cross.click();
    }

    static void openMenu() {
        WebElement menu = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']"));
        menu.click();
    }

    static void myAccountClick () {
        WebElement myaccount = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']/div[@class='Nav']/a[@class='ripple Nav-item '][1]"));
        myaccount.click();
    }

    static void login (String vkName, String vkPassword) {

        WebDriverWait wait = new WebDriverWait(driver,300);

        JoytikaAction.openMenu();
        JoytikaAction.myAccountClick();

        WebElement loginButton = driver.findElement(By.xpath(".//*[@id='blockLogin']/div/div[4]"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='box']/div/input[6]")));

        WebElement vkLoginField = driver.findElement(By.xpath(".//*[@id='box']/div/input[6]"));
        vkLoginField.sendKeys(vkName);

        WebElement vkPasswordField = driver.findElement(By.xpath(".//*[@id='box']/div/input[7]"));
        vkPasswordField.sendKeys(vkPassword);

        WebElement vkLoginButton= driver.findElement(By.xpath(".//*[@id='install_allow']"));
        vkLoginButton.click();

    }

}
