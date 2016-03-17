package joytika.tests.PageFactory


import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions

class VKLoginPage private constructor(private val driver: WebDriver) {
    init {
        PageFactory.initElements(driver, this)
    }

    fun loginInVKLoginForm(vkUsername: String, vkPassword: String) {
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath.LoginWindow.VKLogin.vkLoginField)));
        vkLoginField.sendKeys(vkUsername)
        vkPasswordField.sendKeys(vkPassword)
        vkLoginButton.click()
    }

    companion object {


        @FindBy(how = How.XPATH, using = XPath.VKLogin.vkLoginButton)
        internal var vkLoginButton: WebElement
        @FindBy(how = How.XPATH, using = XPath.VKLogin.vkLoginField)
        internal var vkLoginField: WebElement
        @FindBy(how = How.XPATH, using = XPath.VKLogin.vkPasswordField)
        internal var vkPasswordField: WebElement

        private var INSTANCE: VKLoginPage? = null

        @Synchronized fun getVKLoginPage(webDriver: WebDriver): VKLoginPage {
            if (INSTANCE == null) {
                INSTANCE = VKLoginPage(webDriver)
            }
            return INSTANCE
        }
    }

}
