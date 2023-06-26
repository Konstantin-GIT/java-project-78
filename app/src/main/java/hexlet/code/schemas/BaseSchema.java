package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseSchema {
    protected Map<String, Condition> checks = new LinkedHashMap<>();
    protected boolean required = false;
    protected final void addCheck(String name, Condition validate) {
        checks.put(name, validate);
    }

    public final Boolean isValid(Object comparedValue) {
        if (comparedValue == null) {
            return !required;
        }
        Boolean result = true;
        for (String key : checks.keySet()) {
            result = result && checks.get(key).execute(comparedValue);
        }
        return result;
    }

    interface Condition {
        Boolean execute(Object comparedValue);
    }

}
