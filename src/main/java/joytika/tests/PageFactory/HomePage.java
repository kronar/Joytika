package joytika.tests.PageFactory;

import joytika.tests.Driver.WebDriverHelper;
import joytika.tests.Logic.Tournament;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends PageWithHeader {

    //left button
    //minuses
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideButtons']/div[@class='block-sidewrap-content'][2]/div[@class='block-sidewrap-content-getcoins']/div[@eventtype='1']")
    static WebElement oneMinusesPackButton;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideButtons']/div[@class='block-sidewrap-content'][2]/div[@class='block-sidewrap-content-getcoins']/div[@eventtype='2']")
    static WebElement towMinusesPackButton;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideButtons']/div[@class='block-sidewrap-content'][2]/div[@class='block-sidewrap-content-getcoins']/div[@eventtype='3']")
    static WebElement threeMinusesPackButton;
    //ads
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideButtons']/div[@class='block-sidewrap-content'][3]/div[@class='block-sidewrap-content-getcoins']/div[@eventtype='1']")
    static WebElement oneAdsPackButton;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideButtons']/div[@class='block-sidewrap-content'][3]/div[@class='block-sidewrap-content-getcoins']/div[@eventtype='2']")
    static WebElement towAdsPackButton;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideButtons']/div[@class='block-sidewrap-content'][3]/div[@class='block-sidewrap-content-getcoins']/div[@eventtype='3']")
    static WebElement threeAdsPackButton;

    //right button
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideInfo']/div[@class='block-sidewrap-content'][1]/div[@class='el-button-new _small _green _icon _info _margin']")
    static WebElement rulesButton;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideInfo']/div[@class='block-sidewrap-content'][2]/div[@class='el-button-new _small _blue _icon _vk _margin']")
    static WebElement inviteFriendsButton;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@id='SideInfo']/div[@class='block-sidewrap-content'][3]/div[@class='el-button-new _small _blue _icon _vk _margin']")
    static WebElement joinGroupButton;

    //Tabs
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@class='block-wrapper-centerwrap']/div/div[@class='block-tabs js-tabs-buttons']/div[@tab='past']")
    @CacheLookup
    static WebElement pastTab;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@class='block-wrapper-centerwrap']/div/div[@class='block-tabs js-tabs-buttons']/div[@tab='present']")
    @CacheLookup
    static WebElement currentTab;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@class='block-wrapper-centerwrap']/div/div[@class='block-tabs js-tabs-buttons']/div[@tab='future']")
    @CacheLookup
    static WebElement futureTab;

    //Past additional tabs
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@class='block-wrapper-centerwrap']/div/div[@class='block-tabs-tab js-tab _active']/div/div[@class='block-tabssmall']/div[@tab='past-all']")
    @CacheLookup
    static WebElement pastAllAdditionalTab;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@class='block-wrapper-centerwrap']/div/div[@class='block-tabs-tab js-tab _active']/div/div[@class='block-tabssmall']/div[@tab='past-withme']")
    @CacheLookup
    static WebElement pastWithMeAdditionalTab;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='block-wrapper  ']/div[@id='Tours']/div[@class='block-wrapper-centerwrap']/div/div[@class='block-tabs-tab js-tab _active']/div/div[@class='block-tabssmall']/div[@tab='withmewin']")
    @CacheLookup
    static WebElement pastMyWinAdditionalTab;

    private static HomePage INSTANCE;

    public static synchronized HomePage getHomePage(WebDriver webDriver){
        if (INSTANCE==null){
            INSTANCE = new HomePage(webDriver);
        }
        return INSTANCE;
    }

    private HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void minusesPackButtonClick(final int packNumber) {
        switch (packNumber) {
            case 1:
                oneMinusesPackButton.click();
                break;
            case 2:
                towMinusesPackButton.click();
                break;
            case 3:
                threeMinusesPackButton.click();
                break;
        }
    }

    public void adsPackButtonClick(final int packNumber) {
        switch (packNumber) {
            case 1:
                oneAdsPackButton.click();
                break;
            case 2:
                towAdsPackButton.click();
                break;
            case 3:
                threeAdsPackButton.click();
                break;
        }
    }

    public void tabClick(String tabName) {
        tabName.toUpperCase();
        if (tabName.equals("ПРОШЕДШИЕ")) {
            pastTab.click();

        } else if (tabName.equals("ТЕКУЩИЕ")) {
            currentTab.click();

        } else if (tabName.equals("БУДУЩИЕ")) {
            futureTab.click();

        } else if (tabName.equals("ВСЕ")) {
            pastAllAdditionalTab.click();

        } else if (tabName.equals("С МОИМ УЧАСТИЕМ")) {
            pastWithMeAdditionalTab.click();

        } else if (tabName.equals("МОИ ПОБЕДЫ")) {
            pastMyWinAdditionalTab.click();
        }
    }


    // TODO tournaments ???????
    public static Tournament pressAnyTournament() {
        List<WebElement> tournaments = WebDriverHelper.getCurrentDriver().findElements(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs--tab js-tab _active']/div[@class='block-games-item js-tour-item']"));
        WebElement tournament = tournaments.get(0);
        Tournament tournament1 = new Tournament(tournament.getAttribute("tourid"), tournament.getAttribute("tourtype"), tournament.getAttribute("tourpoints"), tournament.getAttribute("title"));
        tournament.click();
        return tournament1;
    }

    public static int getCurrentTournamentsCount() {
        List<WebElement> tournaments = WebDriverHelper.getCurrentDriver().findElements(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs--tab js-tab _active']/div[@class='block-games-item js-tour-item']/div[@class='block-games-item-wrap']"));
        return tournaments.size();
    }
}
