package joytika.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TabsHelper {

    private static WebElement homeTub;
    private static WebElement pastTub;
    private static WebElement futureTub;

    private static WebElement additionalAllTub;
    private static WebElement additionalPartTub;
    private static WebElement additionalWinTub;


    protected static void initTub() {
        homeTub = JoytikaHelper.getDriver().findElement(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs js-tabs-buttons']")).findElement(By.xpath("//div[text()='Текущие']"));
        pastTub = JoytikaHelper.getDriver().findElement(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs js-tabs-buttons']")).findElement(By.xpath("//div[text()='Прошедшие']"));
        futureTub = JoytikaHelper.getDriver().findElement(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs js-tabs-buttons']")).findElement(By.xpath("//div[text()='Будущие']"));
    }

    private static void initAdditionalTab() {
        JoytikaHelper.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs--tab js-tab _active']/div/div[@class='block-tabssmall']")));
        additionalAllTub = JoytikaHelper.getDriver().findElement(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs--tab js-tab _active']/div/div[@class='block-tabssmall']")).findElement(By.xpath("//span[text()='Все турниры']"));
        additionalPartTub = JoytikaHelper.getDriver().findElement(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs--tab js-tab _active']/div/div[@class='block-tabssmall']")).findElement(By.xpath("//span[text()='С моим участием']"));
        additionalWinTub = JoytikaHelper.getDriver().findElement(By.xpath("/html/body[@id='body']/div[@class='block-wrapper _lightgrey']/div[@id='Tours']/div[3]/div[@class='block-tabs--tab js-tab _active']/div/div[@class='block-tabssmall']")).findElement(By.xpath("//span[text()='Мои победы']"));
    }


    public static void pressToTheTab(String tab) {

        initTub();

        if (tab.equals("ПРОШЕДШИЕ")) {
            pastTub.click();

        } else if (tab.equals("ТЕКУЩИЕ")) {
            homeTub.click();

        } else if (tab.equals("БУДУЩИЕ")) {
            futureTub.click();

        }
    }

    public static void pressToTheAdditionalTab(String tab) {

        initAdditionalTab();
        if (tab.equals("Все турниры")) {
            additionalAllTub.click();
        } else if (tab.equals("С моим участием")) {
            additionalPartTub.click();
        } else if (tab.equals("Мои победы")) {
            additionalWinTub.click();
        }
    }


}
