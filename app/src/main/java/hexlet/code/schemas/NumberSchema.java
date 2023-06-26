package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addCheck(
                "required",
                item ->  item instanceof Integer
        );
    }
    public NumberSchema positive() {
        addCheck("positiveCondition", (item) ->
                ((Number) item).longValue() > 0);
        return this;
    }

    public NumberSchema range(int beginInterval, int endInterval) {
        addCheck("rangeCondition", (item) ->
                ((Number) item).longValue() >= beginInterval
                        && ((Number) item).longValue() <= endInterval);
        return this;
    }

    public NumberSchema required() {
        required = true;
        return this;
    }
}
