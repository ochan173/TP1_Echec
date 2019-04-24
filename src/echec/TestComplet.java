package echec;

import echec.Pieces.TestCompletPieces;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Classe qui exécute tous les tests.
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestComplet extends TestCase {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(TestCompletPieces.suite());
        suite.addTestSuite(TestPosition.class);
        suite.addTestSuite(TestEchiquier.class);
        return suite;
    }
}
