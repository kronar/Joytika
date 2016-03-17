package joytika.tests.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PageWithHeader {
    public static WebDriver driver;

    //header
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']")
    static WebElement menu;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-fixed-righttext js-scrollto']/span[@class='Header-fixed-righttext-text']")
    static WebElement enter;

    public PageWithHeader(WebDriver driver) {
        PageWithHeader.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enter() {
        enter.click();
    }

    public void menuClick() {
        menu.click();
    }
    public String getHeaderTitle(){
        return enter.getText();
    }

    public boolean userIsLogin() {
        return !"Войти".equals(getHeaderTitle());
    }


}
