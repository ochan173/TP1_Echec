package echec;

import echec.Pieces.*;

import java.util.ArrayList;

/**
 * Classe de l'échiquier
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Echiquier {
    private static  Echiquier m_instance;
    private ArrayList<PieceBase> m_echiquier;
    private PieceBase m_pieceCourante;

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

    public PieceBase getPiece(Position p_position) {
        for (PieceBase piece : m_echiquier) {
            if (piece.getPosition().equals(p_position)) {
                return piece;
            }
        }

        return null;
    }

    public void set_pieceCourante(PieceBase m_pieceCourante) {
        this.m_pieceCourante = m_pieceCourante;
    }

    public PieceBase get_pieceCourante() {
        return m_pieceCourante;
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

    public void deplacerPieceCourante(Position p_position) {
        if (mouvementsPiece(m_pieceCourante.getPosition()).contains(p_position)) {
            PieceBase pieceCible = getPiece(p_position);
            if (pieceCible != null) {
                m_echiquier.remove(pieceCible);
            }

            m_pieceCourante.deplacer(p_position);
            m_pieceCourante = null;
        }
    }

    /**
     * Permet d'obtenir les mouvements valides d'une pièce en fonction des autres pièces sur l'échiquier
     * si la piece sur la position est de même couleur on la retire de la liste de mouvements
     * si la piece sur la position est de de couleur différente est de la même couleur on la laisse pour la manger
     * @param p_position la position de la pièce utilisée
     * @return les positions où la pièce peut se déplacer
     */
    public ArrayList<Position> mouvementsPiece(Position p_position) {
        PieceBase piece = getPiece(p_position);
        ArrayList<Position> mouvements = piece.mouvementsPossible();

        if (piece.getType() == PieceBase.TypePiece.CAVALIER) {
            for (Position p : piece.mouvementsPossible()) {
                if (!positionEstLibre(p) && getPiece(p).getCouleur() == piece.getCouleur()) {
                    mouvements.remove(p);
                }
            }
        }
        else if (piece.getType() == PieceBase.TypePiece.PION) {
            for (Position p : piece.mouvementsPossible()) {
                if (!positionEstLibre(p)) {
                    mouvements.remove(p);
                }
            }
            for (Position p : piece.zoneAttaques()) {
                if (!positionEstLibre(p) && getPiece(p).getCouleur() != piece.getCouleur()) {
                    mouvements.add(p);
                }
            }
        }
        else {
            for (Position p : piece.mouvementsPossible()) {
                if (contientPosition(p)) {

                    if (p.getX() == piece.getPosition().getX()) {
                        int x = p.getX();
                        int y = p.getY();

                        if (getPiece(p).getCouleur() == piece.getCouleur()) {
                            if (y > piece.getPosition().getY()) {

                                while (y <= 7) {
                                    mouvements.remove(new Position(x, y++));
                                }
                            } else if (y < piece.getPosition().getY()) {
                                while (y >= 0) {
                                    mouvements.remove(new Position(x, y--));
                                }
                            }
                        } else {

                            if (y > piece.getPosition().getY()) {

                                while (y < 7) {
                                    mouvements.remove(new Position(x, ++y));
                                }
                            } else if (y < piece.getPosition().getY()) {
                                while (y > 0) {
                                    mouvements.remove(new Position(x, --y));
                                }
                            }
                        }
                    } else if (p.getY() == piece.getPosition().getY()) {
                        int x = p.getX();
                        int y = p.getY();

                        if (getPiece(p).getCouleur() == piece.getCouleur()) {

                            if (x > piece.getPosition().getX()) {

                                while (x <= 7) {
                                    mouvements.remove(new Position(x, y));
                                    x++;
                                }
                            } else if (x < piece.getPosition().getX()) {
                                while (x >= 0) {
                                    mouvements.remove(new Position(x, y));
                                    x--;
                                }
                            }
                        } else {

                            if (x > piece.getPosition().getX()) {

                                while (x < 7) {
                                    mouvements.remove(new Position(++x, y));
                                }
                            } else if (x < piece.getPosition().getX()) {
                                while (x > 0) {
                                    mouvements.remove(new Position(--x, y));
                                }
                            }
                        }
                    }

                    // DIAGONALS

                    else if (p.getX() > piece.getPosition().getX() && p.getY() > piece.getPosition().getY()) {
                        int x = p.getX();
                        int y = p.getY();
                        if (getPiece(p).getCouleur() == piece.getCouleur()) {
                            while (x <= 7 && y <= 7) {
                                mouvements.remove(new Position(x++, y++));
                            }
                        } else {
                            while (x < 7 && y < 7) {
                                mouvements.remove(new Position(++x, ++y));
                            }
                        }
                    } else if (p.getX() < piece.getPosition().getX() && p.getY() > piece.getPosition().getY()) {
                        int x = p.getX();
                        int y = p.getY();
                        if (getPiece(p).getCouleur() == piece.getCouleur()) {

                            while (x >= 0 && y <= 7) {
                                mouvements.remove(new Position(x--, y++));
                            }
                        } else {
                            while (x > 0 && y < 7) {
                                mouvements.remove(new Position(--x, ++y));
                            }
                        }
                    } else if (p.getX() < piece.getPosition().getX() && p.getY() < piece.getPosition().getY()) {
                        int x = p.getX();
                        int y = p.getY();
                        if (getPiece(p).getCouleur() == piece.getCouleur()) {

                            while (x >= 0 && y >= 0) {
                                mouvements.remove(new Position(x--, y--));
                            }
                        } else {
                            while (x > 0 && y > 0) {
                                mouvements.remove(new Position(--x, --y));
                            }
                        }
                    } else if (p.getX() > piece.getPosition().getX() && p.getY() < piece.getPosition().getY()) {
                        int x = p.getX();
                        int y = p.getY();
                        if (getPiece(p).getCouleur() == piece.getCouleur()) {
                            while (x <= 7 && y >= 0) {
                                mouvements.remove(new Position(x++, y--));
                            }
                        } else {
                            while (x < 7 && y > 0) {
                                mouvements.remove(new Position(++x, --y));
                            }
                        }
                    }
                }
            }
        }

        return mouvements;
    }


    private boolean contientPosition(Position p_position) {
        for (PieceBase p : m_echiquier) {
            if (p.getPosition().equals(p_position)) {
                return true;
            }
        }

        return false;
    }
}