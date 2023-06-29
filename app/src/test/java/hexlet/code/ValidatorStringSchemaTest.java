package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public final class ValidatorStringSchemaTest {

    @Test
    public void testIsValid() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid("test")).isTrue();
    }

    @Test
    public void testIsValidRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("test")).isTrue();
    }

    @Test
    public void testIsValidContains() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.contains("testWord");

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("testWordExample")).isTrue();
        assertThat(schema.isValid("otherValueWord")).isFalse();
    }

    @Test
    public void testIsValidMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.minLength(2);

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("testWordExample")).isTrue();
        assertThat(schema.isValid("x")).isFalse();
    }

}
