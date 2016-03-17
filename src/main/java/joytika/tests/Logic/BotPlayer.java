package joytika.tests.Logic;


import org.openqa.selenium.JavascriptExecutor;

public class BotPlayer {


    public BotPlayer() {
        JavascriptExecutor js = (JavascriptExecutor) JoytikaHelper.getDriver();
        js.executeScript("(function() {\n" +
                "    var screen = document.getElementById(\"screen\");\n" +
                "    var tapTimes = [];\n" +
                "     \n" +
                "    Analytics.roundEnd = function() {\n" +
                "        for (var i = 0; i < tapTimes.length; i++)\n" +
                "            tapTimes[i] = 0;\n" +
                "        setTimeout(function() { Server.replay(); }, 1000);\n" +
                "    }\n" +
                "     \n" +
                "    Analytics.roundReplay = function() {\n" +
                "        tapTimes = [\n" +
                "            500, 500, 600, 600, 700, \n" +
                "            500, 600, 600, 600, 600, \n" +
                "            600, 800, 600, 600, 1200, \n" +
                "            600, 600, 600, 600, 600, \n" +
                "            1200, 600, 600, 1200, 900, \n" +
                "            600, 600, 900, 600, 600, \n" +
                "            600, 600, 600, 600, 600, \n" +
                "            ];\n" +
                "        resetTimer();\n" +
                "    }\n" +
                "     \n" +
                "    var resetTimer = function() {\n" +
                "        var a = (Server.getTime() * 0.001 * Server.floorsInfo[0].speed + Server.floorsInfo[0].phase) % (2 * Math.PI);\n" +
                "        var b = 2 * Math.PI + 2 * Math.PI - a;\n" +
                "        var c = (b - Server.floorsInfo[0].phase) / Server.floorsInfo[0].speed;\n" +
                "        var delay = c * 1000;\n" +
                " \n" +
                "        console.log(\"HACK :: DELAY = \" + delay);\n" +
                " \n" +
                "        for (var i = 1; i < tapTimes.length; i++)\n" +
                "            tapTimes[i] = tapTimes[i] + tapTimes[i - 1];\n" +
                "        for (var i = 0; i < tapTimes.length; i++)\n" +
                "            tapTimes[i] = tapTimes[i] + Server.getTime() + delay;\n" +
                "        updateTimer();  \n" +
                "    }\n" +
                "     \n" +
                "    var updateTimer = function() {\n" +
                "        if (tapTimes[tapTimes.length - 1] == 0) return;\n" +
                " \n" +
                "        for (var i = 0; i < tapTimes.length; i++) {\n" +
                "            if (tapTimes[i] != 0 && Server.getTime() > tapTimes[i]) {\n" +
                "                var clickEvent = document.createEvent(\"MouseEvents\");\n" +
                "                clickEvent.initEvent(\"click\", true, true);\n" +
                "                screen.dispatchEvent(clickEvent);\n" +
                "                 \n" +
                "                console.log(\"HACK :: tap (\" + (i+1) + \")\");\n" +
                "                tapTimes[i] = 0;\n" +
                "                break;\n" +
                "            }\n" +
                "        }\n" +
                "        setTimeout(updateTimer, 10);\n" +
                "    }\n" +
                "})();");
    }


}
