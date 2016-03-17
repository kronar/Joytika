package joytika.tests.CucumberSteps;

import cucumber.api.java.en.Then;
import joytika.tests.Driver.ProxyServer;
import joytika.tests.Logic.HarExplorer;
import joytika.tests.Logic.ParametersParser;
import net.lightbody.bmp.core.har.Har;
import org.junit.Assert;

import javax.annotation.Nullable;
import java.util.Map;


public class AnalyticsActionSteps {
    @Then("^Отправляется событие с параметрами (.*)$")
    public void sendActionWithParameters(String parametersString) throws Throwable {
        Har har = ProxyServer.getHar();
        @Nullable Map<String, String> parameters = ParametersParser.parseParametersString(parametersString);
        Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters));
    }

    @Then("^Отправляется событие \"(.*)\" с параметрами (.*) и параметрами tour_id, tour_type и tour_points соответствующими турниру$")
    public void sendActionTournamentClickWithParameterPlace(String category, String parametersString) throws Throwable {
        Har har = ProxyServer.getHar();
    //    String parametersStringBuilder = parametersString +
    //            ", category = " + category +
    //            ", tour_id = " + lastPressedTournament.getTour_id() +
    //            ", tour_type = " + lastPressedTournament.getTour_type() +
    //            ", tour_points = " + lastPressedTournament.getTour_points();
    //    @Nullable Map<String, String> parameters = ParametersParser.parseParametersString(parametersStringBuilder);
    //    Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters));
    }

    @Then("^Отправляютя два события. Первое с параметрами (.*) второе с параметрами (.*)$")
    public void sendTowActionWithParameters(String parametersString1, String parametersString2) throws Throwable {
        Har har = ProxyServer.getHar();
        @Nullable Map<String, String> parameters1 = ParametersParser.parseParametersString(parametersString1);
        Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters1));
        @Nullable Map<String, String> parameters2 = ParametersParser.parseParametersString(parametersString1);
        Assert.assertTrue(HarExplorer.searchActionWithParameters(har, parameters2));
    }

}
