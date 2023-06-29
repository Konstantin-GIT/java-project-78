package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected final void addCheck(String name, Predicate validate) {
        checks.put(name, validate);
    }

    public final Boolean isValid(Object comparedValue) {

        Boolean result = true;
        for (String key : checks.keySet()) {
            result = result && checks.get(key).test(comparedValue);
        }
        return result;
    }

}
