package joytika.tests.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends PageWithHeader {

    @FindBy(how = How.XPATH, using = "")
    static WebElement logOutButton;

    private static AccountPage INSTANCE;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static synchronized AccountPage getAccountPage(WebDriver webDriver){
        if (INSTANCE==null){
            INSTANCE = new AccountPage(webDriver);
        }
        return INSTANCE;
    }

    public void logOutButtonClick(){
        logOutButton.click();
    }
}
