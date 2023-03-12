package hexlet.code;

import hexlet.code.schema.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorStringSchemaTest {
    StringSchema schema;

    @BeforeEach
    public void testBefore() {
        this.schema = new StringSchema();
    }

    @Test
    public void testIsValidEmptyString() {
        Boolean actual = schema.isValid("");
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidNullString() {
        Boolean actual = schema.isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidNumberValueForString() {
        Boolean actual = schema.required().isValid(5);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidNotEmptyString() {
        Boolean actual = schema.isValid("case test with false");
        assertEquals(false, actual);
    }
    @Test
    public void testRequiredIsValidNotEmptyString() {
        Boolean actual = schema.required().isValid("case test with false");
        assertEquals(true, actual);
    }

    @Test
    public void testRequiredIsValidNumberValueForString() {
        Boolean actual = schema.required().isValid(5);
        assertEquals(false, actual);
    }
    @Test
    public void testRequiredIsValidNull() {
        Boolean actual = schema.required().isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRequiredIsValidEmptyString() {
        Boolean actual = schema.required().isValid("");
        assertEquals(false, actual);
    }

    @Test
    public void testContainsIsValidForString1() {
        Boolean actual = schema.contains("testWord").isValid("testWord");
        assertEquals(true, actual);
    }

    @Test
    public void testContainsIsValidForString2() {
        Boolean actual = schema.contains("testWord").isValid("otherValueWord");
        assertEquals(false, actual);
    }

    @Test
    public void testContainsIsValidForString3() {
        Boolean actual = schema.contains("Word").isValid("otherValueWord");
        assertEquals(true, actual);
    }

    @Test
    public void testContainsIsValidForString5() {
        Boolean actual = schema.contains("FirstWord").contains("SecondWord").isValid("SecondWord");
        assertEquals(true, actual);
    }

    @Test
    public void testContainsRequiredIsValidForString() {
        Boolean actual = schema.contains("").required().contains("").isValid("");
        assertEquals(false, actual);
    }

    @Test
    public void testMinLengthIsValidForString() {
        Boolean actual = schema.minLength(8).isValid("testWord");
        assertEquals(true, actual);
    }
}
