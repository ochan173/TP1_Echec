package echec.Pieces;

import echec.Position;
import junit.framework.TestCase;

/**
 * Classe de test pour la pièce de base.
 *
 * @author Olivier Chan.
 * @author David Goulet.
 */
public abstract class TestPieceBase extends TestCase {

    /**
     * Pièce utilisée dans les tests.
     */
    PieceBase m_pieceBase;

    /**
     * Permet de créer une pièce d'un enfant pour tester les fonctions de base de toutes les pièces.
     * @param p_couleur couleur donnée à la pièce.
     * @return Une pièce d'une classe enfant.
     */
    abstract protected PieceBase creerPiece(PieceBase.Couleur p_couleur, Position p_position);

    /**
     * Test la création d'une pièce de base.
     */
    public void testCreer() {
        m_pieceBase = creerPiece(PieceBase.Couleur.BLANC, new Position(3,3));
        assertEquals(PieceBase.Couleur.BLANC, m_pieceBase.getCouleur());
        assertEquals(new Position(3,3), m_pieceBase.getPosition());
    }
}
