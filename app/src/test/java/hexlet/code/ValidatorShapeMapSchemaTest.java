package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ValidatorShapeMapSchemaTest {
    MapSchema schema;

    @BeforeEach
    public void testBefore() {
        Validator v = new Validator();
        MapSchema valueSchema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        this.schema = valueSchema.shape(schemas);
    }
    @Test
    public void testIsValidHuman1() {
        Boolean actual = schema.isValid(null);
        assertEquals(true, actual);
    }
    @Test
    public void testIsValidHuman2() {
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Boolean actual = schema.isValid(human2);
        assertEquals(true, actual);
    }
    @Test
    public void testIsValidHuman3() {
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Boolean actual = schema.isValid(human3);
        assertEquals(false, actual);
    }
    @Test
    public void testIsValidHuman4() {
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        Boolean actual = schema.isValid(human4);
        assertEquals(false, actual);
    }
}
