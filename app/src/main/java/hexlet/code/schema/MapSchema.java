package hexlet.code.schema;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private Map<String, Condition> conditions =
            new HashMap<String, Condition>() { { put("initCondition", getInitCondition()); } };

    public MapSchema required() {
        conditions.remove("initCondition");
        conditions.put("requiredCondition", (item) -> item instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        conditions.remove("initCondition");
        conditions.put("sizeofCondition", (item) -> ((Map) item).size() == size);
        return this;
    }


    @Override
    public Condition getInitCondition() {
        return (item) -> item == null;
    }

    @Override
    public Map<String, Condition> getConditions() {
        return conditions;
    }
}
