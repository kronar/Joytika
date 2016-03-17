package joytika.tests.PageFactory;

import joytika.tests.Driver.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by NasyaS on 17.03.2016.
 */
public class VKLoginPage {
    static WebDriver driver;
    @FindBy(how = How.XPATH, using = XPath.VKLogin.vkLoginButton)
    static WebElement vkLoginButton;
    @FindBy(how = How.XPATH, using = XPath.VKLogin.vkLoginField)
    static WebElement vkLoginField;
    @FindBy(how = How.XPATH, using = XPath.VKLogin.vkPasswordField)
    static WebElement vkPasswordField;

    private static VKLoginPage INSTANCE;

    public static synchronized VKLoginPage getVKLoginPage(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new VKLoginPage(webDriver);
        }
        return INSTANCE;
    }

    public VKLoginPage(WebDriver driver) {
        VKLoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginInVKLoginForm(String vkUsername, String vkPassword) {

        WebDriverHelper.getCurrentDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath.VKLogin.vkLoginField)));
        vkLoginField.sendKeys(vkUsername);
        vkPasswordField.sendKeys(vkPassword);
        vkLoginButton.click();
    }
}
