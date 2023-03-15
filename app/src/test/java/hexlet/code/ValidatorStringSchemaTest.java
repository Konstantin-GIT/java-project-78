package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ValidatorStringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    public void testBefore() {
        this.schema = new StringSchema();
    }

    @Test
    public void testIsValidEmptyString() {
        Boolean actual = getSchema().isValid("");
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidNullString() {
        Boolean actual = getSchema().isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidNumberValueForString() {
        Boolean actual = getSchema().required().isValid(5);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidNotEmptyString() {
        Boolean actual = getSchema().isValid("case test with false");
        assertEquals(false, actual);
    }
    @Test
    public void testRequiredIsValidNotEmptyString() {
        Boolean actual = getSchema().required().isValid("case test with false");
        assertEquals(true, actual);
    }

    @Test
    public void testRequiredIsValidNumberValueForString() {
        Boolean actual = getSchema().required().isValid(5);
        assertEquals(false, actual);
    }
    @Test
    public void testRequiredIsValidNull() {
        Boolean actual = getSchema().required().isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRequiredIsValidEmptyString() {
        Boolean actual = getSchema().required().isValid("");
        assertEquals(false, actual);
    }

    @Test
    public void testContainsIsValidForString1() {
        Boolean actual = getSchema().contains("testWord").isValid("testWord");
        assertEquals(true, actual);
    }

    @Test
    public void testContainsIsValidForString2() {
        Boolean actual = getSchema().contains("testWord").isValid("otherValueWord");
        assertEquals(false, actual);
    }

    @Test
    public void testContainsIsValidForString3() {
        Boolean actual = getSchema().contains("Word").isValid("otherValueWord");
        assertEquals(true, actual);
    }

    @Test
    public void testContainsIsValidForString5() {
        Boolean actual = getSchema().contains("FirstWord").contains("SecondWord").isValid("SecondWord");
        assertEquals(true, actual);
    }

    @Test
    public void testContainsRequiredIsValidForString() {
        Boolean actual = getSchema().contains("").required().contains("").isValid("");
        assertEquals(false, actual);
    }

    @Test
    public void testMinLengthIsValidForString() {
        Boolean actual = getSchema().minLength(8).isValid("testWord");
        assertEquals(true, actual);
    }

    public StringSchema getSchema() {
        return schema;
    }
}
