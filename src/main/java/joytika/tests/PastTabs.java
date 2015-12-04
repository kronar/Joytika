package joytika.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PastTabs {

    static final java.lang.String vkName = "89171090130";
    static final java.lang.String vkPassword = "haumlium263";

    public void PastTabsCheck() {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 300);

        driver.get("http://www.joytika.com");

        try {
            WebElement element = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']"));
            element.click();

            WebElement pastButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabs js-site-tabs']/div[@class='block-tabs-item js-head-tab'][1]"));
            pastButton.click();

            if (driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabssmall js-site-tabs']/div[@class='block-tabssmall-item js-head-tab _active']")).isDisplayed()) {
                System.out.println("Тест 1 не прошел");
            } else {
                System.out.println("Тест 1 прошел");
            }


            WebElement menu = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']"));
            menu.click();

            WebElement myaccount = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']/div[@class='Nav']/a[@class='ripple Nav-item '][1]"));
            myaccount.click();

            WebElement loginButton = driver.findElement(By.xpath(".//*[@id='blockLogin']/div/div[4]"));
            loginButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='box']/div/input[6]")));

            WebElement vkLoginField = driver.findElement(By.xpath(".//*[@id='box']/div/input[6]"));
            vkLoginField.sendKeys(vkName);

            WebElement vkPasswordField = driver.findElement(By.xpath(".//*[@id='box']/div/input[7]"));
            vkPasswordField.sendKeys(vkPassword);

            WebElement vkLoginButton = driver.findElement(By.xpath(".//*[@id='install_allow']"));
            vkLoginButton.click();

            if (driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabssmall js-site-tabs']/div[@class='block-tabssmall-item js-head-tab _active']")).isDisplayed()) {
                System.out.println("Тест 2 прошел");
            } else {
                System.out.println("Тест 2 непрошел");
            }


        } catch (NoSuchElementException e) {
            System.out.print("Я не нашееель");
        }
        //driver.quit();
    }

    public static void main(String[] args) {
        new PastTabs().PastTabsCheck();
    }
}
