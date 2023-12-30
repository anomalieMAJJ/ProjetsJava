import java.util.HashMap;
import java.util.Map;
public class codeThaiACodeApiCi implements ThaiTraducteur {
    private static final Map<String, String> codeThaiACodeApiCi = new HashMap<>();
    public codeThaiACodeApiCi() {
        codeThaiACodeApiCi.put("\u0E01", "\u006B");
        codeThaiACodeApiCi.put("\u0E02", "\u006B\u02B0");
        codeThaiACodeApiCi.put("\u0E03", "\u006B\u02B0");
        codeThaiACodeApiCi.put("\u0E04", "\u006B\u02B0");
        codeThaiACodeApiCi.put("\u0E05", "\u006B\u02B0");
        codeThaiACodeApiCi.put("\u0E06", "\u006B\u02B0");
        codeThaiACodeApiCi.put("\u0E07", "\u014B");
        codeThaiACodeApiCi.put("\u0E08", "\u0074\u0255");
        codeThaiACodeApiCi.put("\u0E09", "\u0074\u0255\u02B0");
        codeThaiACodeApiCi.put("\u0E0A", "\u0074\u0255\u02B0");
        codeThaiACodeApiCi.put("\u0E0B", "\u0073");
        codeThaiACodeApiCi.put("\u0E0C", "\u0074\u0255\u02B0");
        codeThaiACodeApiCi.put("\u0E0D", "\u006A");
        codeThaiACodeApiCi.put("\u0E0E", "\u0064");
        codeThaiACodeApiCi.put("\u0E0F", "\u0074");
        codeThaiACodeApiCi.put("\u0E10", "\u0074\u02B0");
        codeThaiACodeApiCi.put("\u0E11", "\u0074\u02B0");
        codeThaiACodeApiCi.put("\u0E12", "\u0074\u02B0");
        codeThaiACodeApiCi.put("\u0E13", "\u006E");
        codeThaiACodeApiCi.put("\u0E14", "\u0064");
        codeThaiACodeApiCi.put("\u0E15", "\u0074");
        codeThaiACodeApiCi.put("\u0E16", "\u0074\u02B0");
        codeThaiACodeApiCi.put("\u0E17", "\u0074\u02B0");
        codeThaiACodeApiCi.put("\u0E18", "\u0074\u02B0");
        codeThaiACodeApiCi.put("\u0E19", "\u006E");
        codeThaiACodeApiCi.put("\u0E1A", "\u0062");
        codeThaiACodeApiCi.put("\u0E1B", "\u0070");
        codeThaiACodeApiCi.put("\u0E1C", "\u0070\u02B0");
        codeThaiACodeApiCi.put("\u0E1D", "\u0066");
        codeThaiACodeApiCi.put("\u0E1E", "\u0070\u02B0");
        codeThaiACodeApiCi.put("\u0E1F", "\u0066");
        codeThaiACodeApiCi.put("\u0E20", "\u0070\u02B0");
        codeThaiACodeApiCi.put("\u0E21", "\u006D");
        codeThaiACodeApiCi.put("\u0E22", "\u006A");
        codeThaiACodeApiCi.put("\u0E23", "\u0072");
        codeThaiACodeApiCi.put("\u0E25", "\u006C");
        codeThaiACodeApiCi.put("\u0E27", "\u0077");
        codeThaiACodeApiCi.put("\u0E28", "\u0073");
        codeThaiACodeApiCi.put("\u0E29", "\u0073");
        codeThaiACodeApiCi.put("\u0E2A", "\u0073");
        codeThaiACodeApiCi.put("\u0E2B", "\u0068");
        codeThaiACodeApiCi.put("\u0E2C", "\u006C");
        codeThaiACodeApiCi.put("\u0E2D", "\u0294");
        codeThaiACodeApiCi.put("\u0E2E", "\u0068");
    }
    public boolean has(String syllabe){
        return codeThaiACodeApiCi.containsKey(syllabe);
    }
    public String get(String syllabe){
        return codeThaiACodeApiCi.get(syllabe);
    }
}
