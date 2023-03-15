package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ValidatorMapSchemaTest {
    private MapSchema schema;

    @BeforeEach

    public void testBefore() {
        Validator v = new Validator();
        this.schema = v.map();
    }

    @Test
    public void testIsValidNull() {
        Boolean actual = getSchema().isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidNotNull() {
        Boolean actual = getSchema().isValid(new HashMap());
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRequiredNull() {
        Boolean actual = getSchema().required().isValid(null);
        assertEquals(false, actual);
    }



    @Test
    public void testIsValidRequiredMap1() {
        Boolean actual = getSchema().required().isValid(new HashMap());
        assertEquals(true, actual);
    }



    @Test
    public void testIsValidRequiredMap2() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Boolean actual = getSchema().required().isValid(data);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRequiredNotMap() {
        Boolean actual = getSchema().required().isValid("testString");
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidSizeOfMap1() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Boolean actual = getSchema().sizeof(2).isValid(data);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidSizeOfMap2() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        Boolean actual = getSchema().sizeof(2).isValid(data);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRequiredSizeOfMap3() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        Boolean actual = getSchema().sizeof(2).required().isValid(data);
        assertEquals(true, actual);
    }

    @Test
    public void testIsValidRequiredSizeOfMap4() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        data.put("key3", "value3");
        Boolean actual = getSchema().sizeof(2).required().isValid(data);
        assertEquals(false, actual);
    }

    @Test
    public void testIsValidRequiredSizeOfMap5() {
        Boolean actual = getSchema().required().sizeof(2).isValid(new HashMap());
        assertEquals(false, actual);
    }


    public MapSchema getSchema() {
        return schema;
    }
}
