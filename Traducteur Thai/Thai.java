
import java.util.*;
/**
    * Cette classe permet de traduire le langage Thai en API.
    */
public class Thai {
    private static final ThaiTraducteur Ci = new codeThaiACodeApiCi();
    private static final ThaiTraducteur Cf = new codeThaiACodeApiCf();
    public static final ThaiTraducteur Voyelles = new codeThaiPatronCodeApiVoyelle();
    public static final String aucunElementTrouve = "aucunelementtrouver";

    public static String versAPI(String texte) throws NoSuchElementException {
        String[] syllabes = texte.split(" ");
        StringBuilder resultat = new StringBuilder();

        for (String syllabe : syllabes) {
            resultat.append(convertirEnSon(syllabe)).append(" ");
        }
        return resultat.toString().trim();
    }
    //Pour trouver les consonnes
    public static ArrayList<Integer> chercherConsonnes(String texte) {
        ArrayList<Integer> indicesConsonnes = new ArrayList<>();
        boolean ciTrouve = false;
        boolean aAjouteCf = false;

        for (int i = 0; i < texte.length(); i++) {
            String currentCharStr = String.valueOf(texte.charAt(i));

            if (!ciTrouve && Ci.has(currentCharStr)) {
                indicesConsonnes.add(i);
                ciTrouve = true;
            }

            if (Cf.has(currentCharStr)) {
                indicesConsonnes.add(i);
            }
        }

        return indicesConsonnes;
    }

    public static String chercherPrononciationVoyelles(String texte) {
        if (Voyelles.has(texte)) {
            return Voyelles.get(texte);
        } else {
            return aucunElementTrouve;
        }

    }

    private static String prononciation(String syllabe) {
        ArrayList<Integer> consonnesIndexes = chercherConsonnes(syllabe);
        String resultat = chercherPrononciationVoyelles(syllabe);

        if (resultat.equals(aucunElementTrouve) && consonnesIndexes.size() > 0) {
            int consonneIndex = consonnesIndexes.get(0);
            String prononciationCi = Ci.get(String.valueOf(syllabe.charAt(consonneIndex)));
            String voyelles = syllabe.substring(0,consonneIndex) + "C" + syllabe.substring(consonneIndex+1);
            resultat = prononciationCi + chercherPrononciationVoyelles(voyelles);
        }
        if (resultat.contains(aucunElementTrouve) && consonnesIndexes.size() > 1) {
            int consonneInitialeIndex = consonnesIndexes.get(0);
            String pasCi = syllabe.substring(0,consonneInitialeIndex) + "C" + syllabe.substring(consonneInitialeIndex+1);
            String prononciationCi = Ci.get(String.valueOf(syllabe.charAt(consonneInitialeIndex)));
            consonnesIndexes.remove(0);

            while (consonnesIndexes.size() > 0 && resultat.contains(aucunElementTrouve)) {
                int cfIndex = consonnesIndexes.get(0);
                consonnesIndexes.remove(0);
                String cfPrononciation = Cf.get(String.valueOf(syllabe.charAt(cfIndex)));
                String pasCiCf = pasCi.substring(0,cfIndex) + "c" + pasCi.substring(cfIndex+1);
                resultat = prononciationCi + chercherPrononciationVoyelles(pasCiCf) + cfPrononciation;
            }
        }

        if (resultat.contains(aucunElementTrouve)) {
            throw new NoSuchElementException();
        }
        return resultat;
    }

    private static String convertirEnSon(String syllabe) {
        if (syllabe.length() == 0) {
            return "";
        } else if (syllabe.length() >= 1 && syllabe.length() <= 5) {
            return prononciation(syllabe);
        } else {
            throw new NoSuchElementException();
        }
    }
}









