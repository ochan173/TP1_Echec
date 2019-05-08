package echec;

import echec.Pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe de l'échiquier
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Echiquier {
    private static  Echiquier m_instance;
    private ArrayList<PieceBase> m_echiquier = null;

    /**
     * Méthode pour avoir l'instance de l'échiquier
     *
     * @return l'instance de l'échiquier
     */
    public static  Echiquier getInstance() {
        if (m_instance == null) {
            m_instance = new Echiquier();
        }

        return  m_instance;
    }

    private Echiquier() {
        m_echiquier = new ArrayList<PieceBase>();
    }

    /**
     * Méthode pour obtenir l'échiquier
     *
     * @return l'échiquier
     */
    ArrayList<PieceBase> getEchiquier() {
        return m_echiquier;
    }

    private PieceBase getPiece(Position p_position) {
        for (PieceBase piece : m_echiquier) {
            if (piece.getPosition().equals(p_position)) {
                return piece;
            }
        }

        return null;
    }

    /**
     * Cette méthode retire toutes les pièces d'un échiquier
     */
    public void resetEchiquier(){
        m_echiquier = new ArrayList<>();
    }

    /**
     * Méthode pour remplir l'échiquier au début de la partie
     */
    public void remplir() {
        //Pions blancs
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
     * Cette méthode vérifie si une pièce occupe la position voulue
     *
     * @param p_position position à vérifier
     * @return Vrai si il n'y a aucune pièce à la position désirée sinon False
     */
    public boolean positionEstLibre(Position p_position) {
        for (PieceBase piece : m_echiquier) {
            if (piece.getPosition().equals(p_position)) {
                if (getPiece(p_position).getCouleur() == piece.getCouleur())
                return false;
            }
        }

        return true;
    }

    private ArrayList<Position> trajetComplet(Position p_actuelle, Position p_nouvelle) {
        ArrayList<Position> trajet = new ArrayList<>();
        int distanceX = p_nouvelle.getX() - p_actuelle.getX();
        int distanceY = p_nouvelle.getY() - p_actuelle.getY();
        int direction = -1;

        //Ligne diagonale
        if (distanceY == distanceX) {
            if (distanceX > 0) {
                direction = 1;
            }
        while (!p_actuelle.equals(p_nouvelle)) {
        }

        }
        //Ligne verticale
        else if (distanceX == 0) {
            if (distanceY > 0) {
                direction = 1;
            }
        }
        //Ligne horizontale
        else {
            if (distanceX > 0) {
                direction = 1;
            }
        }


        return trajet;
    }

    private void getTrajet() {

    }

    public boolean deplacerPiece(Position p_postionActuelle, Position p_nouvellePosition) {
        PieceBase piece = getPiece(p_postionActuelle);
        ArrayList<Position> trajet = new ArrayList<>();

        if (piece == null) {
            return false;
        }

        for (Position position : piece.mouvementsPossible()) {
            for (PieceBase pieceBase : m_echiquier) {
                if (position.equals(pieceBase.getPosition())) {
                    return false;
                }
            }
        }

        if (positionEstLibre(p_nouvellePosition) && piece.deplacer(p_nouvellePosition)) {
            return true;
        }

        return false;
    }



}
