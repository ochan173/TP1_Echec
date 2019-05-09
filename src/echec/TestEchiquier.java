package echec;

import echec.Pieces.*;
import javafx.geometry.Pos;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Classe de test pour l'échiquier
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestEchiquier extends TestCase {
    private ArrayList<PieceBase> m_echiquier = new ArrayList<>();

    /**
     * Setup pour l'échiquier de test
     */
    public void setUp() {
        Echiquier.getInstance().resetEchiquier();
        Echiquier.getInstance().remplir();


        //pions blancs
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(0,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(1,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(2,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(3,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(4,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(5,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(6,1)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.BLANC, new Position(7,1)));

        //Pions noirs
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(0,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(1,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(2,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(3,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(4,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(5,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(6,6)));
        m_echiquier.add(Pion.obtenirPiece(PieceBase.Couleur.NOIR, new Position(7,6)));

        //Tours blanches
        m_echiquier.add(Tour.obtenirPiece(PieceBase.Couleur.BLANC, new Position(0, 0)));
        m_echiquier.add(Tour.obtenirPiece(PieceBase.Couleur.BLANC, new Position(7, 0)));

        //Tours noires
        m_echiquier.add(Tour.obtenirPiece(PieceBase.Couleur.NOIR, new Position(0, 7)));
        m_echiquier.add(Tour.obtenirPiece(PieceBase.Couleur.NOIR, new Position(7, 7)));

        //Cavaliers blancs
        m_echiquier.add(Cavalier.obtenirPiece(PieceBase.Couleur.BLANC, new Position(1, 0)));
        m_echiquier.add(Cavalier.obtenirPiece(PieceBase.Couleur.BLANC, new Position(6, 0)));

        //Cavaliers noirs
        m_echiquier.add(Cavalier.obtenirPiece(PieceBase.Couleur.NOIR, new Position(1, 7)));
        m_echiquier.add(Cavalier.obtenirPiece(PieceBase.Couleur.NOIR, new Position(6, 7)));

        //Fous blancs
        m_echiquier.add(Fou.obtenirPiece(PieceBase.Couleur.BLANC, new Position(2, 0)));
        m_echiquier.add(Fou.obtenirPiece(PieceBase.Couleur.BLANC, new Position(5, 0)));

        //Fous noirs
        m_echiquier.add(Fou.obtenirPiece(PieceBase.Couleur.NOIR, new Position(2, 7)));
        m_echiquier.add(Fou.obtenirPiece(PieceBase.Couleur.NOIR, new Position(5, 7)));

        //Reine blanche
        m_echiquier.add(Reine.obtenirPiece(PieceBase.Couleur.BLANC, new Position(3, 0)));

        //Reine noire
        m_echiquier.add(Reine.obtenirPiece(PieceBase.Couleur.NOIR, new Position(3, 7)));

        //Roi blanc
        m_echiquier.add(Roi.obtenirPiece(PieceBase.Couleur.BLANC, new Position(4, 0)));

        //Roi noir
        m_echiquier.add(Roi.obtenirPiece(PieceBase.Couleur.NOIR, new Position(4, 7)));
    }

    /**
     * Méthode de test pour un nouvel échiquier
     */
    public void testEchiquierDepart() {
        for(PieceBase piece : Echiquier.getInstance().getEchiquier()) {
            assertTrue(m_echiquier.contains(piece));
        }
    }

    /**
     * Méthode de test pour le reset d'un échiquier
     */
    public void testReset() {
        Echiquier.getInstance().resetEchiquier();
        assertEquals(0, Echiquier.getInstance().getEchiquier().size());
    }

    /**
     * Méthode pour tester si une position est libre sur l'échiquier
     */
    public void testPositionLibreSurEchiquier() {
        assertTrue(Echiquier.getInstance().positionEstLibre(new Position(0, 2)));
        assertTrue(Echiquier.getInstance().positionEstLibre(new Position(3, 3)));

        assertFalse(Echiquier.getInstance().positionEstLibre(new Position(0, 1)));
        assertFalse(Echiquier.getInstance().positionEstLibre(new Position(5,7)));

    }

    public void testMouvementsPiece() {
        Echiquier m_echiquier = Echiquier.getInstance();
        assertEquals(new ArrayList<Position>(), m_echiquier.mouvementsPiece(new Position(4, 0)));

        ArrayList<Position> mouvementsPionBlanc = new ArrayList<Position>();
        mouvementsPionBlanc.add(new Position(0,2));
        mouvementsPionBlanc.add(new Position(0,3));
        assertEquals(mouvementsPionBlanc, m_echiquier.mouvementsPiece(new Position(0,1)));

        PieceBase pionBlanc = m_echiquier.getPiece(new Position(4,1));
        pionBlanc.deplacer(new Position(4,3));

        ArrayList<Position> mouvementRoiBlanc = new ArrayList<Position>();
        PieceBase roiBlanc = m_echiquier.getPiece(new Position(4,0));
        assertEquals(PieceBase.TypePiece.ROI, roiBlanc.getType());
        mouvementRoiBlanc.add(new Position(4,1));
        assertEquals(mouvementRoiBlanc, m_echiquier.mouvementsPiece(new Position(4, 0)));

        ArrayList<Position> mouvementsCavalier = new ArrayList<Position>();
        PieceBase cavalierBlanc = m_echiquier.getPiece(new Position(6,0));
        assertEquals(PieceBase.TypePiece.CAVALIER, cavalierBlanc.getType());

        cavalierBlanc.deplacer(new Position(5,2));
        cavalierBlanc.deplacer(new Position(4,4));
        Position cible = new Position(5,6);
        assertTrue(m_echiquier.mouvementsPiece(cavalierBlanc.getPosition()).contains(cible));

        //cavalierBlanc.deplacer(new Position(5,6));

    }

//    public void testDeplacementPiece() {
//        //Déplacement où la pièce n'existe pas
//        assertFalse(Echiquier.getInstance().verificationDeplacement(new Position(4, 5), new Position(3,2)));
//
//        //Déplacement d'un pion
//        assertTrue(Echiquier.getInstance().verificationDeplacement(new Position(1, 1), new Position(1, 2)));
//        assertFalse(Echiquier.getInstance().verificationDeplacement(new Position(1, 1), new Position(1, 4)));
//        assertFalse(Echiquier.getInstance().verificationDeplacement(new Position(1, 1), new Position(3, 2)));
//
//        Echiquier.getInstance().resetEchiquier();
//        Echiquier.getInstance().remplir();
//        //Deplacement d'une tour
//        assertFalse(Echiquier.getInstance().verificationDeplacement(new Position(0, 0), new Position(0, 2)));
//        Echiquier.getInstance().verificationDeplacement(new Position(0, 1), new Position(0, 2));
//        assertTrue(Echiquier.getInstance().verificationDeplacement(new Position(0, 0), new Position(0, 1)));
//    }

}
