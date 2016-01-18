package joytika.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu {
    public static void openMenuItem(String item) {
        JoytikaHelper.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body[@id='body']" +
                "/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']")));

        WebElement menuItem = null;
        if (item.equals("Правила участия")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.rulesMenuItem));

        } else if (item.equals("Условия использования")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.termOfUseMenuItem));

        } else if (item.equals("На главную")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.homeMenuItem));

        } else if (item.equals("Мой аккаунт")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.myAccountItem));

        } else if (item.equals("Получить минусы")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.getMinusMenuItem));

        } else if (item.equals("Поддержка")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.supportMenuItem));

        } else if (item.equals("О нас")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.aboutUsMenuItem));

        } else if (item.equals("Политика безопасности")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.securePolicyMenuItem));

        } else if (item.equals("Joytika ВКонтакте")) {
            menuItem = JoytikaHelper.getDriver().findElement(By.xpath(XPath.Menu.vkMenuItem));

        }
        if (menuItem!=null){
            menuItem.click();
        }
    }

    protected static void openMenu() {
        WebElement menu = JoytikaHelper.getDriver().findElement(By.xpath(XPath.menu));
        menu.click();
    }

}
