package echec.Pieces;

import echec.Position;

import java.util.ArrayList;

/**
 * Classe de la pièce Roi
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Roi extends PieceBase {

    /**
     * Constructeur de base pour une pièce.
     *
     * @param p_couleur  la couleur que la pièce recevera.
     * @param p_type     Type de la pièce.
     * @param p_position La position initiale de la pièce.
     */
    private Roi(Couleur p_couleur, TypePiece p_type, Position p_position) {
        super(p_couleur, p_type, p_position);
    }

    /**
     * Permet d'obtenir une pièce Roi.
     * @param p_couleur couleur de la pièce.
     * @param p_position position de la pièce à la création.
     * @return un nouveau Roi.
     */
    public static PieceBase obtenirPiece(Couleur p_couleur, Position p_position) {
        return new Roi(p_couleur, TypePiece.ROI, p_position);
    }

    @Override
    public ArrayList<Position> mouvementsPossible() {
        ArrayList<Position> mouvements = new ArrayList<>();

        if (this.getPosition().getX() - 1 >= 0) {
            mouvements.add(new Position(this.getPosition().getX() - 1, this.getPosition().getY()));
            if (this.getPosition().getY() - 1 >= 0 ) {
                mouvements.add(new Position(this.getPosition().getX() - 1, this.getPosition().getY() - 1));
            }
            if (this.getPosition().getY() + 1 <= 7) {
                mouvements.add(new Position(this.getPosition().getX() - 1, this.getPosition().getY() + 1));
            }
        }

        if (this.getPosition().getX() + 1 <= 7) {

            mouvements.add(new Position(this.getPosition().getX() + 1, this.getPosition().getY()));
            if (this.getPosition().getY() - 1 >= 0 ) {
                mouvements.add(new Position(this.getPosition().getX() + 1, this.getPosition().getY() - 1));
                mouvements.add(new Position(this.getPosition().getX(), this.getPosition().getY() - 1));
            }
            if (this.getPosition().getY() + 1 <= 7) {
                mouvements.add(new Position(this.getPosition().getX() + 1, this.getPosition().getY() + 1));
                mouvements.add(new Position(this.getPosition().getX(), this.getPosition().getY() + 1));
            }
        }

        return mouvements;
    }
}
