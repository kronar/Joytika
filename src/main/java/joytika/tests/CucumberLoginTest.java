package joytika.tests;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.lightbody.bmp.core.har.Har;
import org.junit.Assert;


public class CucumberLoginTest {

    @Before
    public void doHar() throws Exception {
        JoytikaHelper.initIfNot(CucumperAnalyticsSteps.SITE);
        ProxyServer.doHar();
   }

    @Given("^Пользователь не залогинен$")
    public void visitorWantsToLogin() throws Exception {
       // ProxyServer.doHar();
        JoytikaHelper.pressButtonPlayFromGreetingIfGreetingIsVisible();
        JoytikaHelper.logoutIfNot();
    }

    @When("^Логинится в форме вк с логином (.*) и паролем (.*) и нажимает войти$")
    public void visitorLoginToTheSiteWithVKWithUsernameAndPassword(final String username, final String password) {
        JoytikaHelper.loginInVKLoginForm(username, password);
    }



    @Then("^Visitor should see that he logged in successfully$")
    public void checkSiteHeader() {
        Assert.assertTrue(JoytikaHelper.userIsLogin());
    }



    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Fail Test");
        }
    }

    @And("^Нажимает на пункт (.*)$")
    public void pressItemMenu(String item) throws Throwable {
        JoytikaHelper.openMenuItem(item);
    }

    @And("^Нажимает на кнопку \"Войти через ВКонтакте\" на появившемся окне$")
    public void pressButtonLoginFromNeedLoginWindow() throws Throwable {
        JoytikaHelper.pressButtonLoginFromNeedLoginWindow();
    }
}


