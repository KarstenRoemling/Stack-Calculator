
/**
 * Beschreiben Sie hier die Klasse Tester.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Tester
{
    public Tester() {
        String[] tasks = {"(92 - 79) * 27", "85 - (79 - 43)", "(85 + 34) * (28 - 17)", "85 * ((79 - 23) - 43)", "23"};
        for(int i = 0; i < tasks.length; i++) {
            System.out.println(i+1 + ") berechne " + tasks[i]);
            System.out.println("   Listennotation: " + Calculator.getParsedString(tasks[i]));
            System.out.println("   Ergebnis: " + Calculator.calculate(tasks[i]));
            System.out.println("");
        }
    }
}
