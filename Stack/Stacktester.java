


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse Stacktester.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stacktester
{
    private Stack<String> stack1;

    /**
     * Konstruktor fuer die Test-Klasse Stacktester
     */
    public Stacktester()
    {
    }

    /**
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        stack1 = new Stack<String>();
    }

    /**
     * Gibt das Testgeräst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

   

    @Test
    public void testeKorrektheit()
    {
        assertEquals(true, stack1.isEmpty());
        assertEquals(null, stack1.top());
        stack1.pop();
        stack1.push("P");
        assertEquals("P", stack1.top());
        stack1.push("E");
        assertEquals("E", stack1.top());
        stack1.push("T");
        assertEquals("T", stack1.top());
        stack1.push("E");
        assertEquals("E", stack1.top());
        stack1.push("R");
        assertEquals("R", stack1.top());
        assertEquals(false, stack1.isEmpty());
        assertEquals("R", stack1.top());
        stack1.pop();
        assertEquals("E", stack1.top());
        stack1.pop();
        assertEquals("T", stack1.top());
        stack1.pop();
        assertEquals("E", stack1.top());
        stack1.pop();
        assertEquals("P", stack1.top());
        assertEquals(false, stack1.isEmpty());
        stack1.pop();
        assertEquals(true, stack1.isEmpty());
        assertEquals(null, stack1.top());
    }
}


