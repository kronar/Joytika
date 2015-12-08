package joytika.tests;


import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class JoytikaAnalyticsAction {
    private final String category;
    private HashMap<String, String> parameters = new HashMap<String, String>();

    public JoytikaAnalyticsAction(final String category) {
        this.category = category;
    }

    protected boolean addParameter(@NotNull final String parameterName, @NotNull final String value) {
        if (parameters.containsKey(parameterName)) {
            return false;
        } else {
            parameters.put(parameterName, value);
            return true;
        }
    }

    @Nullable
    protected String getParameter(@NotNull final String parameterName){
        return parameters.get(parameterName);
    }
}
