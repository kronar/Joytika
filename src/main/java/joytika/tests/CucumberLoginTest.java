package joytika.tests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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

    @Given("^Visitor is not logged in$")
    public void visitorWantsToLogin() throws Exception {
        ProxyServer.doHar();
        JoytikaHelper.pressButtonPlayFromGreetingIfGreetingIsVisible();
        JoytikaHelper.logoutIfNot();
    }

    @When("^Visitor login to the site with VK with username (.*) and password (.*)$")
    public void visitorLoginToTheSiteWithVKWithUsernameAndPassword(final String username, final String password) {
        JoytikaHelper.openMenuItemMyAccount();
        JoytikaHelper.pressButtonLoginFromNeedLoginWindow();
        JoytikaHelper.loginInVKLoginForm(username, password);
    }

    @Then("^Visitor should see that he logged in successfully$")
    public void checkSiteHeader() {
        Assert.assertTrue(JoytikaHelper.userIsLogin());
    }

    @When("^Visitor go to the past$")
    public void goToThePast() {
        JoytikaHelper.pressToThePastTab();
    }

    @Then("^Visitor does not see additional tabs$")
    public void checkAdditionalTabsIsNotVisible() {
        Har har = ProxyServer.getHar();

        Assert.assertFalse(JoytikaHelper.additionalTabsIsVisible());
    }

    @Then("^Visitor see additional tabs$")
    public void checkAdditionalTabsIsVisible() {
        Assert.assertTrue(JoytikaHelper.additionalTabsIsVisible());
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
           // try {
           //    byte[] screenshot = ((TakesScreenshot) joytika.getDriver())
          //              .getScreenshotAs(OutputType.BYTES);
          //      scenario.embed(screenshot, "image/png");
          //  } catch (Exception e) {
          //      e.printStackTrace();
          //  }
            //необходимо выводись неверное событие 
        }
    }
}


