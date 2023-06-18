package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addCheck(
                "required",
                item -> item == null || item instanceof Number
        );
    }
    public NumberSchema positive() {
        addCheck("positiveCondition", (item) ->
                item == null ? true : ((Number) item).longValue() > 0);
        return this;
    }

    public NumberSchema range(int beginInterval, int endInterval) {
        addCheck("rangeCondition", (item) ->
                item == null ? false : ((Number) item).longValue() >= beginInterval
                        && ((Number) item).longValue() <= endInterval);
        return this;
    }

    public NumberSchema required() {

        addCheck("requiredCondition", (item) ->
                item == null ? false : (item instanceof Number) && ((Number) item).longValue() >= 0);
        return this;
    }
/*
    public NumberSchema positive() {
        getConditions().remove("initCondition");
        getConditions().put("positiveCondition", (item) ->
                item == null ? true : ((Number) item).longValue() > 0);
        return this;
    }

    public NumberSchema range(int beginInterval, int endInterval) {
        getConditions().remove("initCondition");
        getConditions().put("rangeCondition", (item) ->
                item == null ? false : ((Number) item).longValue() >= beginInterval
                        && ((Number) item).longValue() <= endInterval);
        return this;
    }
*/

}
