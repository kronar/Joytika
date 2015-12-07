package joytika.tests;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CucumberLoginTest {
    WebDriver driver;
    WebDriverWait wait;

    public void webDriverInit(){
        driver = WebDriverHelper.getCurrentDriver();
        wait = WebDriverHelper.getCurrentDriverWait();
        driver.get("http://www.joytika.com");
    }

    @Given("^Visitor wants to login$")
    public void visitorWantsToLogin(){
        webDriverInit();
        WebElement element = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']"));
        element.click();
    }

    @When("^Visitor login to the site with VK with username (.*) and password (.*)$")
    public void visitorLoginToTheSiteWithVKWithUsernameAndPassword(String username, String password){
        WebElement menu = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']"));
        menu.click();

        WebElement myaccount = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']/div[@class='Nav']/a[@class='ripple Nav-item '][1]"));
        myaccount.click();

        WebElement loginButton = driver.findElement(By.xpath(".//*[@id='blockLogin']/div/div[4]"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='box']/div/input[6]")));

        WebElement vkLoginField = driver.findElement(By.xpath(".//*[@id='box']/div/input[6]"));
        vkLoginField.sendKeys(username);

        WebElement vkPasswordField = driver.findElement(By.xpath(".//*[@id='box']/div/input[7]"));
        vkPasswordField.sendKeys(password);

        WebElement vkLoginButton= driver.findElement(By.xpath(".//*[@id='install_allow']"));
        vkLoginButton.click();
    }

    @Then("^Visitor should see that he logged in successfully$")
    public void checkSiteHeader(){
        WebElement userNameAfter = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-fixed-righttext js-scrollto']/a[@class='Header-fixed-righttext-text']"));
        final String nickAfter = userNameAfter.getText();
        Assert.assertFalse("Войти".equals(nickAfter));
    }
}
