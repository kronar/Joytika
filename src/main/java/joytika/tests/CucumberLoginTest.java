package joytika.tests;



import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;


public class CucumberLoginTest {
    private JoytikaHelper joytika = new JoytikaHelper("http://www.joytika.com");

    @Given("^Visitor is not logged in$")
    public void visitorWantsToLogin() {
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


