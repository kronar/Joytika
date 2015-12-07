package joytika.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoytikaHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    JoytikaHelper(final String site) {
        driver = WebDriverHelper.getCurrentDriver();
        wait = WebDriverHelper.getCurrentDriverWait();
        driver.get(site);
    }

    protected void loginIfNotLogin(final String username, final String password) {
        if (!userIsLogin()) {
            login(username, password);
        }
    }

    private void login(final String username, final String password) {
        openMenuItemMyAccount();
        pressButtonLoginFromNeedLoginWindow();
        loginInVKLoginForm(username, password);
    }

    protected void openMenu() {
        WebElement menu = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']"));
        menu.click();
    }

    protected void openMenuItemMyAccount() {
        openMenu();
        WebElement myAccountMenuItem = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']/div[@class='Nav']/a[@class='ripple Nav-item '][1]"));
        myAccountMenuItem.click();
    }


    protected void pressButtonLoginFromNeedLoginWindow() {
        WebElement loginButton = driver.findElement(By.xpath(".//*[@id='blockLogin']/div/div[4]"));
        loginButton.click();
    }

    protected void loginInVKLoginForm(final String vkUsername, final String vkPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='box']/div/input[6]")));

        WebElement vkLoginField = driver.findElement(By.xpath(".//*[@id='box']/div/input[6]"));
        vkLoginField.sendKeys(vkUsername);

        WebElement vkPasswordField = driver.findElement(By.xpath(".//*[@id='box']/div/input[7]"));
        vkPasswordField.sendKeys(vkPassword);

        WebElement vkLoginButton = driver.findElement(By.xpath(".//*[@id='install_allow']"));
        vkLoginButton.click();
    }

    protected String getAccountNick() {
        WebElement userNameAfter = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-fixed-righttext js-scrollto']/a[@class='Header-fixed-righttext-text']"));
        return userNameAfter.getText();
    }

    protected boolean userIsLogin() {
        return !"Войти".equals(getAccountNick());
    }

    protected static void pressCrossFromGreeting() {
        //TODO
    }

    private void logout() {
        openMenuItemMyAccount();
        WebElement logOutButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='chart--newrecord']/div[@class='block-profile']/div[@class='block-profile-text']/a[@class='block-profile-text-logout']"));
        logOutButton.click();
    }

    protected void logoutIfNot() {
        if (userIsLogin()) {
            logout();
        }
    }

    protected void pressButtonPlayFromGreetingIfGreetingIsVisible() {
        if (greetingIsVisible()) {
            WebElement playButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']"));
            playButton.click();
        }
    }

    private boolean greetingIsVisible() {
        try {
            WebElement greeting = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']"));
            return greeting.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    public void goToThePastTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabs js-site-tabs']/div[@class='block-tabs-item js-head-tab'][1]")));
        WebElement pastButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabs js-site-tabs']/div[@class='block-tabs-item js-head-tab'][1]"));
        pastButton.click();
    }

    public boolean additionalTabsIsVisible() {
        return driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabssmall js-site-tabs']/div[@class='block-tabssmall-item js-head-tab'][1]")).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
