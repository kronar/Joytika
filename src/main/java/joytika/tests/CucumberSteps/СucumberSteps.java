package joytika.tests.CucumberSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import joytika.tests.Driver.ProxyServer;
import joytika.tests.Driver.WebDriverHelper;
import joytika.tests.Logic.Tournament;
import org.openqa.selenium.WebDriver;


public class СucumberSteps {

    public static final String SITE = "http://www.joytika.com";
    private Tournament lastPressedTournament = null;
    WebDriver driver = WebDriverHelper.getCurrentDriver();

    @Before
    public void doHar() throws Exception {
        JoytikaHelper.initIfNot(SITE);
        ProxyServer.doHar();
    }


    @When("^Пользователь нажимает на кнопку Выиграть приз$")
    public void pressPlayButtonFromTournamentPage() throws Throwable {
        //JoytikaHelper.pressPlayButtonFromTournamentPage();
    }


    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Fail Test");
        }
    }


}
