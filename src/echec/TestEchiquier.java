package echec;

import echec.Pieces.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

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
        Echiquier.getInstance().remplir();

        for(PieceBase piece : Echiquier.getInstance().getEchiquier()) {
            assertTrue(m_echiquier.contains(piece));
        }
        //assertEquals(m_echiquier, Echiquier.getInstance().getEchiquier());
    }
}
