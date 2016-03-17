package joytika.tests.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Menu {
    private static WebDriver driver;
    private static Menu INSTANCE;
    public Menu(WebDriver driver) {
        Menu.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //menu items
//TODO надо бы доделать
    @FindBy(how = How.XPATH, using = "")
    static WebElement rulesMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement termOfUseMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement homeMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement securePolicyMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement supportMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement aboutUsMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement vkMenuItem;
    @FindBy(how = How.XPATH, using = "")
    static WebElement myAccountItem;


    public void openMenuItem(String item) {
        ///??
        // JoytikaHelper.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body[@id='body']" +
        //          "/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']")));

        if (item.equals("Правила участия")) {
            rulesMenuItem.click();
        } else if (item.equals("Условия использования")) {
            termOfUseMenuItem.click();
        } else if (item.equals("На главную")) {
            homeMenuItem.click();
        } else if (item.equals("Мой аккаунт")) {
            myAccountItem.click();
        } else if (item.equals("Поддержка")) {
            supportMenuItem.click();
        } else if (item.equals("О нас")) {
            aboutUsMenuItem.click();
        } else if (item.equals("Политика безопасности")) {
            securePolicyMenuItem.click();
        } else if (item.equals("Joytika ВКонтакте")) {
            vkMenuItem.click();
        }
    }

    public static synchronized Menu getMenu(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new Menu(webDriver);
        }
        return INSTANCE;
    }
}
