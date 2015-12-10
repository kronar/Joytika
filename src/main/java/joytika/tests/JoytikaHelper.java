package joytika.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoytikaHelper {

    private static WebDriver driver;
    private static WebDriverWait wait;

    protected static void init(final String site) {
        driver = WebDriverHelper.getCurrentDriver();
        wait = WebDriverHelper.getCurrentDriverWait();
        driver.get(site);
    }

    protected static void initIfNot(final String site) {
        if (!isInit()) {
            init(site);
        }
    }

    private static boolean isInit() {
        return driver != null && wait != null;
    }

    protected static void loginIfNotLogin(final String username, final String password) {
        if (!userIsLogin()) {
            login(username, password);
        }
    }

    private static void login(final String username, final String password) {
        openMenuItemMyAccount();
        pressButtonLoginFromNeedLoginWindow();
        loginInVKLoginForm(username, password);
    }

    protected static void openMenu() {
        WebElement menu = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']"));
        menu.click();
    }

    protected static void openMenuItemMyAccount() {
        openMenu();
        WebElement myAccountMenuItem = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']/div[@class='Nav']/a[@class='ripple Nav-item '][1]"));
        myAccountMenuItem.click();
    }


    protected static void pressButtonLoginFromNeedLoginWindow() {
        WebElement loginButton = driver.findElement(By.xpath(".//*[@id='blockLogin']/div/div[4]"));
        loginButton.click();
    }

    protected static void loginInVKLoginForm(final String vkUsername, final String vkPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='box']/div/input[6]")));

        WebElement vkLoginField = driver.findElement(By.xpath(".//*[@id='box']/div/input[6]"));
        vkLoginField.sendKeys(vkUsername);

        WebElement vkPasswordField = driver.findElement(By.xpath(".//*[@id='box']/div/input[7]"));
        vkPasswordField.sendKeys(vkPassword);

        WebElement vkLoginButton = driver.findElement(By.xpath(".//*[@id='install_allow']"));
        vkLoginButton.click();
    }

    protected static String getAccountNick() {
        WebElement userNameAfter = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-fixed-righttext js-scrollto']/a[@class='Header-fixed-righttext-text']"));
        return userNameAfter.getText();
    }

    protected static boolean userIsLogin() {
        return !"Войти".equals(getAccountNick());
    }

    protected static void pressCrossFromGreeting() {
        //TODO
    }

    private static void logout() {
        openMenuItemMyAccount();
        WebElement logOutButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='chart--newrecord']/div[@class='block-profile']/div[@class='block-profile-text']/a[@class='block-profile-text-logout']"));
        logOutButton.click();
    }

    protected static void logoutIfNot() {
        if (userIsLogin()) {
            logout();
        }
    }

    protected static void pressButtonPlayFromGreetingIfGreetingIsVisible() {
        if (greetingIsVisible()) {
            WebElement playButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']"));
            playButton.click();
        }
    }

    private static boolean greetingIsVisible() {
        try {
            WebElement greeting = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']"));
            return greeting.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    public static void pressToThePastTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabs js-site-tabs']/div[@class='block-tabs-item js-head-tab'][1]")));
        WebElement pastButton = driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabs js-site-tabs']/div[@class='block-tabs-item js-head-tab'][1]"));
        pastButton.click();
    }

    public static boolean additionalTabsIsVisible() {
        return driver.findElement(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='block-tabssmall js-site-tabs']/div[@class='block-tabssmall-item js-head-tab'][1]")).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
