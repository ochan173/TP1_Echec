package echec.Pieces;

import echec.Position;

public class TestRoi extends TestPieceBase {
    @Override
    protected PieceBase creerPiece(PieceBase.Couleur p_couleur, Position p_position) {
        return Roi.obtenirPiece(p_couleur, p_position);
    }

    public void testType() {
        assertEquals(PieceBase.TypePiece.ROI, super.m_pieceBase.getType());
    }

    public void testDeplacementValide() {

        // VALIDATION POSITIVE

        super.m_pieceBase.deplacer(new Position(2,2));
        assertEquals(new Position(2,2), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(1,2));
        assertEquals(new Position(1,2), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(0,1));
        assertEquals(new Position(0,1), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(0,0));
        assertEquals(new Position(0,0), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(1,0));
        assertEquals(new Position(1,0), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(1,1));
        assertEquals(new Position(1,1), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(2,0));
        assertEquals(new Position(2,0), m_pieceBase.getPosition());

        super.m_pieceBase.deplacer(new Position(1,1));
        assertEquals(new Position(1,1), m_pieceBase.getPosition());

        // VALIDATION NÉGATIVE

    }
}
