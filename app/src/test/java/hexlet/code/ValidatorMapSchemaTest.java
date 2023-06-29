package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public final class ValidatorMapSchemaTest {

    @Test
    public void testIsValid() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(new HashMap())).isTrue();
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    public void testIsValidRequired() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        schema.required();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap())).isTrue();
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    public void testIsValidRequiredSizeOf() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        schema.required().sizeof(3);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap())).isFalse();
        assertThat(schema.isValid(data)).isFalse();

        data.put("key2", "value2");
        data.put("key3", "value3");
        assertThat(schema.isValid(data)).isTrue();
    }

}
