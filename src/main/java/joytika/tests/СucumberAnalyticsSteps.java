package joytika.tests;

        import cucumber.api.java.Before;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import net.lightbody.bmp.core.har.Har;
        import org.junit.Assert;
        import javax.annotation.Nullable;
        import java.util.Map;


public class СucumberAnalyticsSteps {

    protected static final String SITE = "http://www.joytika.com";

    @Before
    public void doHar() throws Exception {
        JoytikaHelper.initIfNot(SITE);
        ProxyServer.doHar();
    }

    @When("^Пользователь нажимает на кнопку играть на гритинге$")
    public void visitorPressToPlayButton() {
        JoytikaHelper.pressButtonPlayFromGreetingIfGreetingIsVisible();
    }

    @Then("^Отправляется событие с параметрами (.*)$")
    public void sendActionWithParameters(String parametersString) throws Throwable {
        Har har = ProxyServer.getHar();
        @Nullable Map<String, String> parameters = ParametersParser.parseParametersString(parametersString);
        Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters));
    }

    @Then("^Отправляютя два события. Первое с параметрами (.*) второе с параметрами (.*)$")
    public void sendTowActionWithParameters(String parametersString1 , String parametersString2) throws Throwable {
        Har har = ProxyServer.getHar();
        @Nullable Map<String, String> parameters1 = ParametersParser.parseParametersString(parametersString1);
        Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters1));
        @Nullable Map<String, String> parameters2 = ParametersParser.parseParametersString(parametersString1);
        Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters2));
    }

    @When("^Пользователь нажимает вкладку (.*)$")
    public void visitorPressToTheTap(String tapName) throws Throwable {
        JoytikaHelper.pressToTheTab(tapName);

    }
    @When("^Пользователь нажимает на дополнительную вкладку (.*)$")
    public void visitorPressToTheAdditionalTap(String tapName) throws Throwable {
        JoytikaHelper.pressToTheAdditionalTab(tapName);

    }

    @When("^Пользователь открывает меню$")
    public void visitorOpenMenu() throws Throwable {
        JoytikaHelper.openMenu();
    }

    @And("^Нажать кнопку играть на туторе$")
    public void pressPlayTutorButton() throws Throwable {
        JoytikaHelper.pressPlayTutorButton();
    }
}
