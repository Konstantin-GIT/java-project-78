package hexlet.code;

import hexlet.code.schema.MapSchema;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        Validator v = new Validator();

        MapSchema schema = v.map();

        schema.isValid(null); // true

        schema.required();

        schema.isValid(null); // false
        schema.isValid(new HashMap()); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        schema.isValid(data); // true
        System.out.println(schema.isValid(data));
        schema.sizeof(2);

        System.out.println(schema.isValid(data));
        data.put("key2", "value2");
        schema.isValid(data); // true
        System.out.println(schema.isValid(data));
    }
}
