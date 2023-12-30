import java.util.HashMap;
import java.util.Map;

public class codeThaiPatronCodeApiVoyelle implements ThaiTraducteur {
        private static final Map<String, String> codeThaiPatronACodeApiVoyelle = new HashMap<>();
        public codeThaiPatronCodeApiVoyelle() {
                //Données des patrons de code Thai et Code API Voyelle
                codeThaiPatronACodeApiVoyelle.put("\u0E33","\u0061\u006D");
                codeThaiPatronACodeApiVoyelle.put("\u0E24","\u0072\u026F");
                codeThaiPatronACodeApiVoyelle.put("\u0E26","\u006c\u026f");
                codeThaiPatronACodeApiVoyelle.put("C", "\u0061\u0294");

                codeThaiPatronACodeApiVoyelle.put("\u0E24\u0E45", "\u0072\u026F\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E26\u0E45", "\u006C\u026F\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E30", "\u0061\u0294");
                codeThaiPatronACodeApiVoyelle.put("C\u0E32", "\u0061\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E34", "\u0069");
                codeThaiPatronACodeApiVoyelle.put("C\u0E35", "\u0069\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E36", "\u026F");
                codeThaiPatronACodeApiVoyelle.put("C\u0E38", "\u0075");
                codeThaiPatronACodeApiVoyelle.put("C\u0E39", "\u0075\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E34", "\u0069");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C", "\u0065\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E41C", "\u025B\u02D0");
                codeThaiPatronACodeApiVoyelle.put("Cc", "\u006F\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E42C", "\u006F\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E2D", "\u0254\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E23", "\u0254\u02D0\u006E"); //fixed from the doc (adding \u006E at the end that was missing)
                codeThaiPatronACodeApiVoyelle.put("\u0E43C", "\u0061\u006A");
                codeThaiPatronACodeApiVoyelle.put("\u0E44C", "\u0061\u006A");

                codeThaiPatronACodeApiVoyelle.put("C\u0E31c", "\u0061\u0294");
                codeThaiPatronACodeApiVoyelle.put("C\u0E32c", "\u0061\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E34c", "\u0069");
                codeThaiPatronACodeApiVoyelle.put("C\u0E35c", "\u0069\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E36c", "\u026F");
                codeThaiPatronACodeApiVoyelle.put("C\u0E37\u0E2D", "\u026F\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E37c", "\u026F\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E38c", "\u0075");
                codeThaiPatronACodeApiVoyelle.put("C\u0E39c", "\u0075\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E30", "\u0065");
                codeThaiPatronACodeApiVoyelle.put("\u0E40Cc", "\u0065\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E41C\u0E30", "\u025B\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E41Cc", "\u025B\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E42C\u0E30", "\u006F\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E42Cc", "\u006F\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E2Dc", "\u0254\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E2D", "\u0264\u02D0");
                codeThaiPatronACodeApiVoyelle.put("C\u0E31\u0E27", "\u0075\u0061");
                codeThaiPatronACodeApiVoyelle.put("C\u0E27c", "\u0075\u0061");
                codeThaiPatronACodeApiVoyelle.put("C\u0E34\u0E27", "\u0069\u0077");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E27", "\u0065\u02D0\u0077");
                codeThaiPatronACodeApiVoyelle.put("\u0E41C\u0E27", "\u025B\u02D0\u0077");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E32", "\u0061\u0077");
                codeThaiPatronACodeApiVoyelle.put("C\u0E32\u0E27", "\u0061\u02D0\u0077");
                codeThaiPatronACodeApiVoyelle.put("C\u0E31\u0E22", "\u0061\u006A");
                codeThaiPatronACodeApiVoyelle.put("\u0E44C\u0E22", "\u0061\u006A");
                codeThaiPatronACodeApiVoyelle.put("C\u0E32\u0E22", "\u0061\u02d0\u006A");
                codeThaiPatronACodeApiVoyelle.put("C\u0E2D\u0E22", "\u0254\u02d0\u006A");
                codeThaiPatronACodeApiVoyelle.put("C\u0E42\u0E22", "\u006F\u02d0\u006A");
                codeThaiPatronACodeApiVoyelle.put("C\u0E38\u0E22", "\u0075\u006A");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E22", "\u0264\u02D0\u006A");
                codeThaiPatronACodeApiVoyelle.put("C\u0E27\u0E22", "\u0075\u0061\u006A");

                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E47c", "\u0065");
                codeThaiPatronACodeApiVoyelle.put("\u0E41C\u0E47c", "\u025B\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E2Dc", "\u0264\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E34c", "\u0264\u02D0");
                codeThaiPatronACodeApiVoyelle.put("\u0e40C\u0e32\u0E30", "\u0254\u0294");
                codeThaiPatronACodeApiVoyelle.put("C\u0E47\u0E2Dc", "\u0254\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E2D\u0E30", "\u0264\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E35\u0E22", "\u0069\u0061");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E37\u0E2D", "\u026F\u0061");
                codeThaiPatronACodeApiVoyelle.put("C\u0E31\u0E27\u0E30", "\u0075\u0061\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0e40C\u0e47\u0e27", "\u0065\u0077");
                codeThaiPatronACodeApiVoyelle.put("C\u0E47\u0E2D\u0E22", "\u0254\u006A");

                codeThaiPatronACodeApiVoyelle.put("\u0e40C\u0e35\u0e22\u0e30", "\u0069\u0061\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E35\u0E22c", "\u0069\u0061");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E37\u0E2D\u0e30", "\u026F\u0061\u0294");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E37\u0E2Dc", "\u026F\u0061");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E35\u0E22\u0e27", "\u0069\u0061\u0077");
                codeThaiPatronACodeApiVoyelle.put("\u0E40C\u0E37\u0E2D\u0e22", "\u026F\u0061\u006A");

        }
        public boolean has(String syllabe){
                return codeThaiPatronACodeApiVoyelle.containsKey(syllabe);
        }
        public String get(String syllabe){
                return codeThaiPatronACodeApiVoyelle.get(syllabe);
        }

}