package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class StringSchema {
    private Operation initCondition = (x) -> x == null ? true : x.equals("");

    private Map<String, Operation> conditions =
            new HashMap<String, Operation>() { { put("initCondition", initCondition); } };

    public StringSchema contains(String searchSubString) {
        conditions.remove("initCondition");
        conditions.put("containsCondition", (x) -> x.toString().contains(searchSubString));
        return this;
    }

    public StringSchema required() {
        conditions.remove("initCondition");
        conditions.put("requiredCondition",
                (x) -> x == null ? false : x instanceof String && x.toString().length() > 0);
        return this;
    }

    public StringSchema minLength(int minLength) {
        conditions.remove("initCondition");
        conditions.put("minLengthCondition",
                (x) ->  x == null ? false : x instanceof String && x.toString().length() >= minLength);
        return this;
    }

    public Boolean isValid(Object string) {
        Boolean result = true;
        for (String key : conditions.keySet()) {
            result = result && conditions.get(key).execute(string);
        }
        return result;
    }

    interface Operation {
        Boolean execute(Object value);

    }
}

