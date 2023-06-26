package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addCheck(
                "required",
                (item) -> item instanceof Map
        );
    }

    public MapSchema required() {
        required = true;
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

}
