package hexlet.code;

public class App {

    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();
        System.out.println(schema.contains("test").isValid("tes1t"));
    }
}
