package joytika.tests;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.lightbody.bmp.core.har.Har;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CucumberLoginTest {
    private JoytikaHelper joytika = new JoytikaHelper("http://www.joytika.com");

    @Given("^Visitor is not logged in$")
    public void visitorWantsToLogin() throws Exception {
        ProxyServer.doHar();
        joytika.pressButtonPlayFromGreetingIfGreetingIsVisible();
        joytika.logoutIfNot();
    }

    @When("^Visitor login to the site with VK with username (.*) and password (.*)$")
    public void visitorLoginToTheSiteWithVKWithUsernameAndPassword(final String username, final String password) {
        joytika.openMenuItemMyAccount();
        joytika.pressButtonLoginFromNeedLoginWindow();
        joytika.loginInVKLoginForm(username, password);
    }

    @Then("^Visitor should see that he logged in successfully$")
    public void checkSiteHeader() {
        Assert.assertTrue(joytika.userIsLogin());
    }

    @When("^Visitor go to the past$")
    public void goToThePast() {
        joytika.goToThePastTab();
    }

    @Then("^Visitor does not see additional tabs$")
    public void checkAdditionalTabsIsNotVisible() {
        Har har = ProxyServer.getHar();
      //  HarParser.writeHARDataInFile(har);
        Assert.assertFalse(joytika.additionalTabsIsVisible());
    }

    @Then("^Visitor see additional tabs$")
    public void checkAdditionalTabsIsVisible() {
        Assert.assertTrue(joytika.additionalTabsIsVisible());
    }

   // @After
 //   public void embedScreenshot(Scenario scenario) {
   //     if (scenario.isFailed()) {
   //         try {
   //             byte[] screenshot = ((TakesScreenshot) joytika.getDriver())
   //                     .getScreenshotAs(OutputType.BYTES);
    //            scenario.embed(screenshot, "image/png");
    //        } catch (Exception e) {
    //            e.printStackTrace();
   //         }
   //     }
   // }
}


