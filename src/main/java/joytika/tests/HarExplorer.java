package joytika.tests;


import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class HarExplorer {
    private static final String CATEGORY = "category";
    private static final String PLACE = "place";
    private static final String TYPE = "type";
    private static final String GROUP = "group";
    private static final String PAGE = "page";

    private static List<String> getAllJoytikaAnalyticsActions(@NotNull final Har har) {
        String url;
        List<HarEntry> harEntries = har.getLog().getEntries();
        List<String> analyticsActionUrls = new ArrayList<String>();
        for (HarEntry he : harEntries) {
            url = he.getRequest().getUrl();
            if (url.contains("stats.joytika.com")) {
                System.out.println();
                System.out.println(url);
                analyticsActionUrls.add(url);
            }
        }
        return analyticsActionUrls;
    }


    public static boolean searchActionWithCategoryPlacePageTypeGroup(Har har, String category, String place, String page, String type, String group) {
        List<String> analyticsActionUrls = getAllJoytikaAnalyticsActions(har);
        for (String actionUrl : analyticsActionUrls) {
            if (!checkParameter(actionUrl, CATEGORY, category)) {
                continue;
            }
            if (!checkParameter(actionUrl, PLACE, place)) {
                continue;
            }
            if (!checkParameter(actionUrl, TYPE, type)) {
                continue;
            }
            if (!checkParameter(actionUrl, GROUP, group)) {
                continue;
            }
            if (!checkParameter(actionUrl, PAGE, page)) {
                continue;
            }
            return true;
        }
        return false;
    }

    private static boolean checkParameter(@NotNull final String actionUrl, @NotNull final String parameterName, @NotNull final String value) {
        return actionUrl.contains(parameterName + "=" + value) || actionUrl.contains("[" + parameterName + "]=" + value);
    }

    public static boolean searchActionWithCategoryPlaceGroup(Har har, String category, String place, String group) {
        List<String> analyticsActionUrls = getAllJoytikaAnalyticsActions(har);
        for (String actionUrl : analyticsActionUrls) {
            if (!checkParameter(actionUrl, CATEGORY, category)) {
                continue;
            }
            if (!checkParameter(actionUrl, PLACE, place)) {
                continue;
            }
            if (!checkParameter(actionUrl, GROUP, group)) {
                continue;
            }
            return true;
        }
        return false;
    }
}
