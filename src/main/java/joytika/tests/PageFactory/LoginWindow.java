package joytika.tests.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginWindow {
    static WebDriver driver;

    @FindBy(how = How.XPATH, using = "")
    static WebElement cross;
    @FindBy(how = How.XPATH, using = "")
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
