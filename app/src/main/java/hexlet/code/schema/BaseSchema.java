package hexlet.code.schema;

import java.util.Map;

public abstract class BaseSchema {
    public abstract Condition getInitCondition();

    public abstract Map<String, Condition> getConditions();

    public Boolean isValid(Object comparedValue) {
        Boolean result = true;
        for (String key : getConditions().keySet()) {
            result = result && getConditions().get(key).execute(comparedValue);
        }
        return result;

    }
    interface Condition {
        Boolean execute(Object comparedValue);
    }

}
