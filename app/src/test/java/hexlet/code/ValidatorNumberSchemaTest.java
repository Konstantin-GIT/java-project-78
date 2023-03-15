package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ValidatorNumberSchemaTest {
    NumberSchema schema;

    @BeforeEach
    public void testBefore() {
        this.schema = new NumberSchema();
    }

    @Test
    public void testIsValidNull() {
        Boolean actual = schema.isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidNotNull() {
        Boolean actual = schema.isValid(5);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRequiredNull() {
        Boolean actual = schema.required().isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRequiredNumber() {
        Boolean actual = schema.required().isValid(5);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRequiredNotPositive() {
        Boolean actual = schema.required().isValid(-1);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRequiredNotNumber() {
        Boolean actual = schema.required().isValid("testString");
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRequiredPositiveNumber() {
        Boolean actual = schema.required().positive().isValid(0);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidPositiveNumber() {
        Boolean actual = schema.positive().isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRangeNull() {
        Boolean actual = schema.range(5, 10).isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRangeNumber() {
        Boolean actual = schema.range(5, 10).isValid(6);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRangeNumber1() {
        Boolean actual = schema.range(5, 10).isValid(5);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRangeNumber2() {
        Boolean actual = schema.range(-5, 10).isValid(-2);
        assertEquals(true, actual);
    }
    @Test
    public void testIsValidRangePositiveNumber() {
        Boolean actual = schema.positive().range(-5, 10).isValid(-2);
        assertEquals(false, actual);
    }

}
