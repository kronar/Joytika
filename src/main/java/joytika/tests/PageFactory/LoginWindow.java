package joytika.tests.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginWindow {
    static WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='modal-tutor js-login   _active']/div[@id='blockLogin']/div[@class='block-tutor-inner']/div[@class='typo-padding16 typo-center']/div[@class='block-tutor-inner-close windowClose']")
    static WebElement cross;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='modal-tutor js-login   _active']/div[@id='blockLogin']/div[@class='block-tutor-inner']/div[@class='el-button-new _icon _vk _blue typo-marginbot18']")
    static WebElement loginButton;


    public LoginWindow(WebDriver driver) {
        LoginWindow.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static LoginWindow INSTANCE;

    public static synchronized LoginWindow getLoginWindow(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new LoginWindow(webDriver);
        }
        return INSTANCE;
    }
    public void crossClick(){
        cross.click();
    }

    public void loginButtonClick(){
        loginButton.click();
    }
}
