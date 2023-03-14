package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class NumberSchema extends BaseSchema {

    private Map<String, Condition> conditions =
            new HashMap<String, Condition>() { { put("initCondition", getInitCondition()); } };

    public NumberSchema required() {
        getConditions().remove("initCondition");
        getConditions().put("requiredCondition", (item) ->
                item == null ? false : (item instanceof Number) && ((Number) item).longValue() >= 0);
        return this;
    }

    public NumberSchema positive() {
        getConditions().remove("initCondition");
        getConditions().put("positiveCondition", (item) ->
                item == null ? true : (item instanceof Number) && ((Number) item).longValue() > 0);
        return this;
    }

    public NumberSchema range(int beginInterval, int endInterval) {
        getConditions().remove("initCondition");
        getConditions().put("rangeCondition", (item) ->
                item == null ? false : (item instanceof Number)
                        && ((Number) item).longValue() >= beginInterval
                        && ((Number) item).longValue() <= endInterval);
        return this;
    }

    @Override
    public Condition getInitCondition() {
        return (x) -> x == null;
    }

    @Override
    public Map<String, Condition> getConditions() {
        return conditions;
    }
}
