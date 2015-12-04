package joytika.tests;

/**
 * Created by MashaN on 04.12.2015.
 */
public class JoytikaXpath {
    public static String tutorButton = "/html/body[@id='body']/div[@class='modal-tutor js-big-tutor _dota _active']/div[@class='block-greetings']/div[@class='nano has-scrollbar']/div[@class='block-greetings-inner nano-content']/div[@class='block-greetings-inner-button']/div[@class='chart--content-button windowClose']";
    public static String cross = "/html/body[@id='body']/div[@class='modal-tutor js-login _dota _active']/div[@id='blockLogin']/div[@class='block-tutor-inner']/div[@class='block-tutor-inner-close windowClose']";
    public static String leftmenu = "/html/body[@id='body']/div[@class='Header-fixed _animation']/div[@class='Header-menu']";

    public static class Menu {
        public static String myaccount = "/html/body[@id='body']/div[@class='Menu _animation']/div[@class='Menu-body nano _animation has-scrollbar']/div[@class='nano-content']/div[@class='Nav']/a[@class='ripple Nav-item '][1]";
    }


    public static class LoginWindow {
        public static String loginButton = ".//*[@id='blockLogin']/div/div[4]";
        public static String vkLoginField = ".//*[@id='box']/div/input[6]";
        public static String vkPasswordField = ".//*[@id='box']/div/input[7]";
        public static String vkLoginButton = ".//*[@id='install_allow']";
        public static String loginBox = ".//*[@id='box']/div/input[6]";
    }

}
