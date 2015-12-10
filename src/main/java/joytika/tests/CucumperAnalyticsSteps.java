package joytika.tests;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.lightbody.bmp.core.har.Har;
import org.junit.Assert;


public class CucumperAnalyticsSteps {


    protected static final String SITE = "http://www.joytika.com";

    @Before
    public void doHar() throws Exception {
        JoytikaHelper.initIfNot(SITE);
        ProxyServer.doHar();
    }

    @Given("^Visitor come and see greeting$")
    public void visitorSeesGreeting() throws Exception {
        ProxyServer.doHar();
    }

    @When("^Visitor press to play button$")
    public void visitorPressToPlayButton() {
        JoytikaHelper.pressButtonPlayFromGreetingIfGreetingIsVisible();
    }

    @Then("^Send action tutor_click with type = (.*), place = (.*), page = (.*), group = (.*)$")
    public void checkActionsTutorClickWithCategoryPlacePageTypeGroup(String type, String place, String page, String group) {
        final String TUTOR_CLICK = "tutor_click";
        Har har = ProxyServer.getHar();
        Assert.assertTrue(HarExplorer.searchActionWithCategoryPlacePageTypeGroup(har, TUTOR_CLICK, place, page, type, group));
    }

    @Given("^Visitor came to the site already$")
    public void visitorInSite() throws Exception {
        ProxyServer.doHar();
        JoytikaHelper.pressButtonPlayFromGreetingIfGreetingIsVisible();
    }

    @When("^Visitor press to the PAST tap$")
    public void visitorPressPastTab() {
        JoytikaHelper.pressToThePastTab();
    }

    @Then("^Send action tab_click with place = (.*), group = (.*)$")
    public void checkActionsTabClickWithCategoryPlaceGroup(String place, String group) {
        final String TAB_CLICK = "tab_click";
        Har har = ProxyServer.getHar();
        Assert.assertTrue(HarExplorer.searchActionWithCategoryPlaceGroup(har, TAB_CLICK, place, group));
    }

}
