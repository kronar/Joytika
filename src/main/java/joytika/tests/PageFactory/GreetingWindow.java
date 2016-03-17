package joytika.tests.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GreetingWindow {
    private final WebDriver driver;
    private static GreetingWindow INSTANCE;

    public GreetingWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content typo-padding16']/div[@class='block-tutor-inner-close windowClose']")
    static WebElement cross;
    @FindBy(how = How.XPATH, using = "/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content typo-padding16']/div[@class='block-greetings-inner-button']/div[@class='el-button-new windowClose']")
    static WebElement playButton;


    public HomePage pressCross() {
        cross.click();
        return HomePage.getHomePage(driver);
    }

    public HomePage pressPlayButton() {
        playButton.click();
        return HomePage.getHomePage(driver);
    }

    public static synchronized GreetingWindow getGreetingWindow(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new GreetingWindow(webDriver);
        }
        return INSTANCE;
    }

    public boolean isVisible() {
        try {
            WebElement greeting = driver.findElement(By.xpath(XPath.Greeting.greeting));
            return greeting.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

}

