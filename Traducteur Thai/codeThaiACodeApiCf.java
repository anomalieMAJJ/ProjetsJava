import java.util.HashMap;
import java.util.Map;

public class codeThaiACodeApiCf implements ThaiTraducteur {
    private static final Map<String, String> codeThaiACodeApiCf = new HashMap<>();

    public codeThaiACodeApiCf() {
        codeThaiACodeApiCf.put("\u0E01", "\u006B");
        codeThaiACodeApiCf.put("\u0E02", "\u006B");
        codeThaiACodeApiCf.put("\u0E03", "\u006B");
        codeThaiACodeApiCf.put("\u0E04", "\u006B");
        codeThaiACodeApiCf.put("\u0E05", "\u006B");
        codeThaiACodeApiCf.put("\u0E06", "\u006B");
        codeThaiACodeApiCf.put("\u0E07", "\u014B");
        codeThaiACodeApiCf.put("\u0E08", "\u0074");
        codeThaiACodeApiCf.put("\u0E09", "");
        codeThaiACodeApiCf.put("\u0E0A", "\u0074");
        codeThaiACodeApiCf.put("\u0E0B", "\u0074");
        codeThaiACodeApiCf.put("\u0E0C", "");
        codeThaiACodeApiCf.put("\u0E0D", "\u006E");
        codeThaiACodeApiCf.put("\u0E0E", "\u0074");
        codeThaiACodeApiCf.put("\u0E0F", "\u0074");
        codeThaiACodeApiCf.put("\u0E10", "\u0074");
        codeThaiACodeApiCf.put("\u0E11", "\u0074");
        codeThaiACodeApiCf.put("\u0E12", "\u0074");
        codeThaiACodeApiCf.put("\u0E13", "\u006E");
        codeThaiACodeApiCf.put("\u0E14", "\u0074");
        codeThaiACodeApiCf.put("\u0E15", "\u0074");
        codeThaiACodeApiCf.put("\u0E16", "\u0074");
        codeThaiACodeApiCf.put("\u0E17", "\u0074");
        codeThaiACodeApiCf.put("\u0E18", "\u0074");
        codeThaiACodeApiCf.put("\u0E19", "\u006E");
        codeThaiACodeApiCf.put("\u0E1A", "\u0070");
        codeThaiACodeApiCf.put("\u0E1B", "\u0070");
        codeThaiACodeApiCf.put("\u0E1C", "");
        codeThaiACodeApiCf.put("\u0E1D", "");
        codeThaiACodeApiCf.put("\u0E1E", "\u0070");
        codeThaiACodeApiCf.put("\u0E1F", "\u0070");
        codeThaiACodeApiCf.put("\u0E20", "\u0070");
        codeThaiACodeApiCf.put("\u0E21", "\u006D");
        codeThaiACodeApiCf.put("\u0E22", "\u006A");
        codeThaiACodeApiCf.put("\u0E23", "\u006E");
        codeThaiACodeApiCf.put("\u0E25", "\u006E");
        codeThaiACodeApiCf.put("\u0E27", "\u0077");
        codeThaiACodeApiCf.put("\u0E28", "\u0074");
        codeThaiACodeApiCf.put("\u0E29", "\u0074");
        codeThaiACodeApiCf.put("\u0E2A", "\u0074");
        codeThaiACodeApiCf.put("\u0E2B", "");
        codeThaiACodeApiCf.put("\u0E2C", "\u006E");
        codeThaiACodeApiCf.put("\u0E2D", "");
        codeThaiACodeApiCf.put("\u0E2E", "");
    }
    public boolean has(String syllabe){
        return codeThaiACodeApiCf.containsKey(syllabe);
    }
    public String get(String syllabe){
        return codeThaiACodeApiCf.get(syllabe);
    }
}
