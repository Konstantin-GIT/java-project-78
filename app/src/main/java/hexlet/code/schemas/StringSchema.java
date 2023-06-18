package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addCheck(
                "required",
                item -> item == null ? true : item instanceof String
        );
    }

    public StringSchema contains(String searchSubString) {
        addCheck("containsCondition", (x) -> x.toString().contains(searchSubString));
        return this;
    }

    public StringSchema required() {
        addCheck("requiredCondition",
                (x) -> x == null ? false : x instanceof String && x.toString().length() > 0);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck("minLengthCondition",
                (x) ->  x == null ? false : x.toString().length() >= minLength);
        return this;
    }

}

