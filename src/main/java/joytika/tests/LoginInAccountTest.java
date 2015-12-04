package joytika.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginInAccountTest {

    static final java.lang.String vkName = "89171090130";
    static final java.lang.String vkPassword = "haumlium263";

    public void LogInVKCheck (){

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,300);

        driver.get("http://www.joytika.com");

       try {
           WebElement element = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']"));
           element.click();
           WebElement userNameBefore = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-fixed-righttext js-scrollto']/a[@class='Header-fixed-righttext-text']"));

           final String joytikaNickBefore = userNameBefore.getText();

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

           WebElement vkLoginButton= driver.findElement(By.xpath(".//*[@id='install_allow']"));
           vkLoginButton.click();

           WebElement userNameAfter = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-fixed-righttext js-scrollto']/a[@class='Header-fixed-righttext-text']"));
           final String joytikaNickAfter = userNameAfter.getText();

          if(joytikaNickAfter.equals(joytikaNickBefore)){
              System.out.println("1 тест не прошел");
          }else { System.out.println("1 тест прошел");}


       }catch ( NoSuchElementException e){
           System.out.print("Я не нашееель");
       }
        //driver.quit();
    }

    public static void main(String[] args) {
        new LoginInAccountTest().LogInVKCheck();
    }
}
