package joytika.tests.PageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TournamentPage {

    @FindBy(how = How.XPATH, using = "")
    static WebElement playButton;

    public TournamentPage(WebDriver driver) {
        LoginWindow.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void playButtonClick(){
        playButton.click();
    }


    private static TournamentPage INSTANCE;

    public static synchronized TournamentPage getTournamentPage(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new TournamentPage(webDriver);
        }
        return INSTANCE;
    }
}
