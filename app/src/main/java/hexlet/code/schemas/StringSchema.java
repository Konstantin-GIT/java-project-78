package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addCheck(
                "required",
                item -> item instanceof String
        );
    }

    public StringSchema contains(String searchSubString) {
        addCheck("containsCondition", (item) -> item.toString().contains(searchSubString));
        return this;
    }

    public StringSchema required() {
        required = true;
        addCheck(
                "required_str",
                item -> !((String) item).isEmpty()
        );
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck("minLengthCondition",
                (item) ->  item.toString().length() >= minLength);
        return this;
    }

}

