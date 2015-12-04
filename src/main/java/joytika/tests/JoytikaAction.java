package joytika.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    static void tutorClickCross(){}

}
