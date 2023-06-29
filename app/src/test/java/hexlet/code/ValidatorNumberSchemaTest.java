package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public final class ValidatorNumberSchemaTest {

    @Test
    public void testIsValid() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(5)).isTrue();
    }


    @Test
    public void testIsValidRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(-5)).isTrue();
        assertThat(schema.isValid("testNumberType")).isFalse();
    }

    @Test
    public void testIsValidPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.required().positive();

        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(-5)).isFalse();
        assertThat(schema.isValid("testNumberType")).isFalse();
    }

    @Test
    public void testIsValidRequiredPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.required().positive();

        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(-5)).isFalse();
        assertThat(schema.isValid("testNumberType")).isFalse();
    }

    @Test
    public void testIsValidRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.range(5, 10);

        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(7)).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("testType")).isFalse();
    }

    @Test
    public void testIsValidRequiredRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.required().range(5, 10);

        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(7)).isTrue();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("testType")).isFalse();
    }

}
