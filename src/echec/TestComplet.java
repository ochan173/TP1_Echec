package echec;

import echec.Pieces.TestCompletPieces;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestComplet extends TestCase {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(TestCompletPieces.suite());
        suite.addTestSuite(TestPosition.class);
        return suite;
    }
}
