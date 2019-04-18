package echec.Pieces;

import echec.Position;

import java.util.ArrayList;

public class TestRoi extends TestPieceBase {
    @Override
    protected PieceBase creerPiece(PieceBase.Couleur p_couleur, Position p_position) {
        return Roi.obtenirPiece(p_couleur, p_position);
    }

    public void setUp() {
        m_pieceBase = creerPiece(PieceBase.Couleur.BLANC, new Position(1,1));
    }

    public void testType() {
        assertEquals(PieceBase.TypePiece.ROI, super.m_pieceBase.getType());
    }

    public void testDeplacementValide() {

        // VALIDATION POSITIVE

        assertTrue(super.m_pieceBase.deplacer(new Position(2,2)));
        assertEquals(new Position(2,2), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(1,2)));
        assertEquals(new Position(1,2), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(0,1)));
        assertEquals(new Position(0,1), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(0,0)));
        assertEquals(new Position(0,0), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(1,0)));
        assertEquals(new Position(1,0), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(1,1)));
        assertEquals(new Position(1,1), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(2,0)));
        assertEquals(new Position(2,0), m_pieceBase.getPosition());

        assertTrue(super.m_pieceBase.deplacer(new Position(1,1)));
        assertEquals(new Position(1,1), m_pieceBase.getPosition());

        // VALIDATION NÉGATIVE

        assertFalse(super.m_pieceBase.deplacer(new Position(3,1)));
        assertEquals(new Position(1,1), m_pieceBase.getPosition());

        assertFalse(super.m_pieceBase.deplacer(new Position(1,3)));
        assertEquals(new Position(1,1), m_pieceBase.getPosition());
    }

    public void testMouvementPossible() {

        ArrayList<Position> positionsAttendues = new ArrayList<Position>();
        positionsAttendues.add(new Position(2,2));
        positionsAttendues.add(new Position(1,2));
        positionsAttendues.add(new Position(0,1));
        positionsAttendues.add(new Position(0,0));
        positionsAttendues.add(new Position(1,0));
        positionsAttendues.add(new Position(1,1));
        positionsAttendues.add(new Position(2,1));
        positionsAttendues.add(new Position(1,1));

        assertEquals(positionsAttendues, m_pieceBase.mouvementPossible());
    }
}
