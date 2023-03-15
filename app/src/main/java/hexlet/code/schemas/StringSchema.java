package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class StringSchema extends BaseSchema {

    private Map<String, Condition> conditions =
            new HashMap<String, Condition>() { { put("initCondition", getInitCondition()); } };

    public StringSchema contains(String searchSubString) {
        getConditions().remove("initCondition");
        getConditions().put("containsCondition", (x) -> x.toString().contains(searchSubString));
        return this;
    }

    public StringSchema required() {
        getConditions().remove("initCondition");
        getConditions().put("requiredCondition",
                (x) -> x == null ? false : x instanceof String && x.toString().length() > 0);
        return this;
    }

    public StringSchema minLength(int minLength) {
        getConditions().remove("initCondition");
        getConditions().put("minLengthCondition",
                (x) ->  x == null ? false : x instanceof String && x.toString().length() >= minLength);
        return this;
    }

    @Override
    public Condition getInitCondition() {
        return (x) -> x == null ? true : x.equals("");
    }

    @Override
    public Map<String, Condition> getConditions() {
        return conditions;
    }
}

