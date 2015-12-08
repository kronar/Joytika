package joytika.tests;


import edu.umass.cs.benchlab.har.HarEntries;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class HarParser {

    protected static List<String> getAnalyticsAction(@NotNull final Har har) {
        String url;
        List<HarEntry> harEntries = har.getLog().getEntries();
        List<String> analyticsActionUrls = new ArrayList<String>();
        for (HarEntry he : harEntries) {
            url = he.getRequest().getUrl();
            if (url.contains("stats.joytika.com")) {
                System.out.println(url);
                analyticsActionUrls.add(url);
            }
        }
        return analyticsActionUrls;
    }
    protected static boolean searchAnalyticsAction(List<String> analyticsActionUrls){
        for (String  url : analyticsActionUrls) {

        }

        return false;
    }
}
