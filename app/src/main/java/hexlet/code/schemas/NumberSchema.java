package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        super();
    }
    public NumberSchema positive() {
        addCheck("positiveCondition", (item) -> item == null
                || ((Number) item).longValue() > 0);
        return this;
    }

    public NumberSchema range(int beginInterval, int endInterval) {
        addCheck("rangeCondition", (item) -> item == null
                || ((Number) item).longValue() >= beginInterval
                && ((Number) item).longValue() <= endInterval);
        return this;
    }

    public NumberSchema required() {
        addCheck(
                "required",
                item ->  item instanceof Integer
        );
        return this;
    }
}
