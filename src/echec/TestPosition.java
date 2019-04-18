package echec;

import junit.framework.TestCase;

/**
 * Classe de tests pour une position.
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestPosition extends TestCase {
    /**
     * Test pour la création d'une position.
     */
    public void testCreation() {
        Position p = new Position(0, 0);
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());

        Position p2 = new Position(4, 7);
        assertEquals(4, p2.getX());
        assertEquals(7, p2.getY());
    }

    /**
     * Test pour la modification d'une position.
     */
    public void testModifier() {
        Position p = new Position(4, 7);
        p.modifierPosition(new Position(6,4));
        assertEquals(6, p.getX());
        assertEquals(4, p.getY());
    }
}
