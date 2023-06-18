package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addCheck(
                "required",
                (item) -> item == null || item instanceof Map
        );

    }

    private Map<String, BaseSchema> schemas = new HashMap<>();

    public MapSchema required() {
        addCheck("requiredCondition", (item) -> item instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeofCondition", (item) -> ((Map) item).size() == size);
        return this;
    }



    public MapSchema shape(Map<String, BaseSchema> valueSchemas) {
        addCheck("shape",
                value -> {
                    return valueSchemas.entrySet().stream().allMatch(e -> {
                        Object v = ((Map) value).get(e.getKey());
                        return e.getValue().isValid(v);
                    });
                }
        );
        return this;
    }

    /*public Boolean isValid(Map<String, Object> data) {
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
    }*/


}
