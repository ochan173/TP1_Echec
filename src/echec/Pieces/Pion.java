package echec.Pieces;

import echec.Position;

import java.util.ArrayList;

/**
 * Classe de la pièce Pion.
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Pion extends PieceBase {

    private int m_positionYInitiale;
    /**
     * Constructeur de base pour une pièce.
     *
     * @param p_couleur  la couleur que la pièce recevera.
     * @param p_type     Type de la pièce.
     * @param p_position La position initiale de la pièce.
     */
    private Pion(Couleur p_couleur, TypePiece p_type, Position p_position) {
        super(p_couleur, p_type, p_position);
        if ( p_couleur == Couleur.BLANC) {
            m_positionYInitiale = 1;
        }
        else {
            m_positionYInitiale = 6;
        }
    }

    /**
     * Permet d'obtenir une pièce Pion.
     * @param p_couleur couleur de la pièce.
     * @param p_position position de la pièce à la création.
     * @return un nouveau Pion.
     */
    public static PieceBase obtenirPiece(Couleur p_couleur, Position p_position) {
        return new Pion(p_couleur, TypePiece.PION, p_position);
    }

    @Override
    public ArrayList<Position> mouvementsPossible() {
        ArrayList<Position> mouvements = new ArrayList<>();

        mouvements.add(new Position(this.getPosition().getX(), this.getPosition().getY() + this.getCouleur().getDirection()));
        if (m_positionYInitiale == this.getPosition().getY()) {
            mouvements.add(new Position(this.getPosition().getX(), this.getPosition().getY() + this.getCouleur().getDirection() * 2));
        }

        return mouvements;
    }

    @Override
    public ArrayList<Position> zoneAttaques() {
        ArrayList<Position> positionsAttaque = new ArrayList<>();

        positionsAttaque.add(new Position(this.getPosition().getX() - 1, this.getPosition().getY() + this.getCouleur().getDirection()));
        positionsAttaque.add(new Position(this.getPosition().getX() + 1, this.getPosition().getY() + this.getCouleur().getDirection()));

        return positionsAttaque;
    }
}
