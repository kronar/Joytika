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

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
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
        Menu.openMenuItem("Мой аккаунт");
        pressButtonLoginFromNeedLoginWindow();
        loginInVKLoginForm(username, password);
    }

    protected static void openMenu() {
        Menu.openMenu();
    }


    protected static void pressButtonLoginFromNeedLoginWindow() {
        WebElement loginButton = driver.findElement(By.xpath(XPath.LoginWindow.loginButton));
        loginButton.click();
    }

    protected static void loginInVKLoginForm(final String vkUsername, final String vkPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath.LoginWindow.VKLogin.vkLoginField)));

        WebElement vkLoginField = driver.findElement(By.xpath(XPath.LoginWindow.VKLogin.vkLoginField));
        vkLoginField.sendKeys(vkUsername);

        WebElement vkPasswordField = driver.findElement(By.xpath(XPath.LoginWindow.VKLogin.vkPasswordField));
        vkPasswordField.sendKeys(vkPassword);

        WebElement vkLoginButton = driver.findElement(By.xpath(XPath.LoginWindow.VKLogin.vkLoginButton));
        vkLoginButton.click();
    }

    protected static String getAccountNick() {
        WebElement userNameAfter = driver.findElement(By.xpath(XPath.userNickInHeader));
        return userNameAfter.getText();
    }

    protected static boolean userIsLogin() {
        return !"Войти".equals(getAccountNick());
    }

    protected static void pressCrossFromGreeting() {
        //TODO
    }

    private static void logout() {
        Menu.openMenuItem("Мой аккаунт");
        WebElement logOutButton = driver.findElement(By.xpath(XPath.MyAccount.logOutButton));
        logOutButton.click();
    }

    protected static void logoutIfNot() {
        if (userIsLogin()) {
            logout();
        }
    }

    protected static void pressButtonPlayFromGreetingIfGreetingIsVisible() {
        if (greetingIsVisible()) {
            WebElement playButton = driver.findElement(By.xpath(XPath.Greeting.greetingPlayButton));
            playButton.click();
        }
    }

    private static boolean greetingIsVisible() {
        try {
            WebElement greeting = driver.findElement(By.xpath(XPath.Greeting.greeting));
            return greeting.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }


    public static void pressToTheTournament(final int tour_id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body[@id='body']/div[@class='chart--content _daily _dota']/div[@class='chart--content-abswrap']/div[@class='chart--content-blocks js-head-block _active']/div[@class='block-games-item js-tournament-item'][1]/div[@class='block-games-item-wrap']/div[@class='block-games-item-wrap-border']/div[@class='block-games-item-title']/span[1]")));
        Tournament tour = TournamentHelper.getCurrentTournament(tour_id);
        assert tour != null;
        tour.pressPlayButton();
    }

    public static void pressToTheTab(String tab) {
        TabsHelper.pressToTheTab(tab);
    }

    public static void pressToTheAdditionalTab(String tab) {
        TabsHelper.pressToTheAdditionalTab(tab);
    }

    public static void openMenuItem(String item) {
        Menu.openMenuItem(item);
    }

    public static void pressPlayTutorButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath.tutorButton)));
        WebElement button = driver.findElement(By.xpath(XPath.tutorButton));
        button.click();


    }
}
