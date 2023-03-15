package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private Map<String, Condition> conditions =
            new HashMap<String, Condition>() { { put("initCondition", getInitCondition()); } };

    private Map<String, BaseSchema> schemas = new HashMap<>();

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

    public MapSchema shape(Map<String, BaseSchema> valueSchemas) {
        this.schemas = valueSchemas;
        return this;
    }

    public Boolean isValid(Map<String, Object> data) {
        if (schemas.isEmpty() || data == null) {
            return super.isValid(data);
        }
        for (String key: data.keySet()) {
            Object checkedValue = data.get(key);
            if (schemas.containsKey(key)) {
                BaseSchema currentSchema = schemas.get(key);
                Boolean currentCheckedStatus = currentSchema.isValid(checkedValue);
                if (!currentCheckedStatus) {
                    return false;
                }
            }
        }
        return true;


    }


    @Override
    public Condition getInitCondition() {
        return (item) -> item == null || ((Map) item).isEmpty();
    }

    @Override
    public Map<String, Condition> getConditions() {
        return conditions;
    }
}
