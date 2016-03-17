package joytika.tests.CucumberSteps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import joytika.tests.Driver.ProxyServer;
import joytika.tests.Driver.WebDriverHelper;
import joytika.tests.Logic.Tournament;
import joytika.tests.PageFactory.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepsInHomePage {
    public static final String SITE = "http://www.joytika.com";
    private Tournament lastPressedTournament = null;
    WebDriver driver = WebDriverHelper.getCurrentDriver();

    @Before
    public void doHar() throws Exception {
        JoytikaHelper.initIfNot(SITE);
        ProxyServer.doHar();
    }

    @Given("^Пользователь не залогинен$")
    public void visitorWantsToLogin() throws Exception {
        HomePage homePage = HomePage.getHomePage(driver);
        if (homePage.userIsLogin()) {
            homePage.menuClick();
            Menu.getMenu(driver).openMenuItem("Мой аккаунт");
            AccountPage.getAccountPage(driver).logOutButtonClick();
        }
    }

    @When("^Пользователь нажимает на кнопку играть на гритинге$")
    public void visitorPressToPlayButton() {
        GreetingWindow.getGreetingWindow(driver).pressPlayButton();
    }

    @When("^Пользователь нажимает вкладку (.*)$")
    public void visitorPressToTheTap(String tapName) throws Throwable {
        HomePage.getHomePage(driver).tabClick(tapName);
    }

    @When("^Пользователь открывает меню$")
    public void visitorOpenMenu() throws Throwable {
        HomePage.getHomePage(driver).menuClick();
    }

    @When("^Логинится в форме вк с логином (.*) и паролем (.*) и нажимает войти$")
    public void visitorLoginToTheSiteWithVKWithUsernameAndPassword(final String username, final String password) {
        VKLoginPage.Companion.getVKLoginPage(driver).loginInVKLoginForm(username, password);
    }

    @And("^Нажать кнопку играть на туторе$")
    public void pressPlayTutorButton() throws Throwable {
        TutorWindow.getTutorWindow(driver).playButtonClick();
    }

    @And("^Пользователь нажимает на карточку любого турнира$")
    public void pressTournament() throws Throwable {
        lastPressedTournament = JoytikaHelper.pressTournament();
    }

    @And("^Нажимает на пункт (.*)$")
    public void pressItemMenu(String item) throws Throwable {
        Menu.getMenu(driver).openMenuItem(item);
    }

    @And("^Нажимает на кнопку \"Войти через ВКонтакте\" на появившемся окне$")
    public void pressButtonLoginFromNeedLoginWindow() throws Throwable {
        LoginWindow.getLoginWindow(driver).loginButtonClick();
    }

    @Then("^Visitor should see that he logged in successfully$")
    public void checkSiteHeader() {
        Assert.assertTrue(HomePage.getHomePage(driver).userIsLogin());
    }

}
