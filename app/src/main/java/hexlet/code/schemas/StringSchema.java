package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    public StringSchema contains(String searchSubString) {
        addCheck("containsCondition", (item) -> item == null
                || item.toString().contains(searchSubString));
        return this;
    }

    public StringSchema required() {
        addCheck(
                "required",
                item -> item instanceof String && !((String) item).isEmpty()
        );
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck("minLengthCondition",
                (item) ->  item == null || item.toString().length() >= minLength);
        return this;
    }

}

