package joytika.tests.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TutorWindow {

    static WebDriver driver;
    @FindBy(how = How.XPATH, using = "")
    static WebElement cross;
    @FindBy(how = How.XPATH, using = "")
    static WebElement playButton;
    @FindBy(how = How.XPATH, using = "")
    static WebElement leftButton;
    @FindBy(how = How.XPATH, using = "")
    static WebElement rightButton;

    public TutorWindow(WebDriver driver) {
        LoginWindow.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void crossClick(){
        cross.click();
    }
    public void playButtonClick(){
        playButton.click();
    }
    public void leftButtonClick(){
        leftButton.click();
    }
    public void rightButtonClick(){
        rightButton.click();
    }

    private static TutorWindow INSTANCE;

    public static synchronized TutorWindow getTutorWindow(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new TutorWindow(webDriver);
        }
        return INSTANCE;
    }


}
