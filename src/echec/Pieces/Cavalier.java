package echec.Pieces;

import echec.Position;
import echec.PositionInvalideException;

import java.util.ArrayList;

/**
 * Classe de la pièce Cavalier.
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Cavalier extends PieceBase {

    /**
     * Constructeur de base pour une pièce.
     *
     * @param p_couleur  la couleur que la pièce recevera.
     * @param p_type     Type de la pièce.
     * @param p_position La position initiale de la pièce.
     */
    private Cavalier(Couleur p_couleur, TypePiece p_type, Position p_position) {
        super(p_couleur, p_type, p_position);
    }

    /**
     * Permet d'obtenir une pièce Cavalier.
     * @param p_couleur couleur de la pièce.
     * @param p_position position de la pièce à la création.
     * @return un nouveau Cavalier.
     */
    public static PieceBase obtenirPiece(Couleur p_couleur, Position p_position) {
        return new Cavalier(p_couleur, TypePiece.CAVALIER, p_position);
    }

    @Override
    public ArrayList<Position> mouvementsPossible() {
        ArrayList<Position> mouvements = new ArrayList<>();

        int plus = 1;
        int moins = -1;
        int plus2 = 2;
        int moins2 = -2;

        try {
            mouvements.add(new Position(this.getPosition().getX() + plus, this.getPosition().getY()+plus2));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + moins, this.getPosition().getY()+plus2));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + plus, this.getPosition().getY()+moins2));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + moins, this.getPosition().getY()+moins2));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + plus2, this.getPosition().getY()+plus));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + moins2, this.getPosition().getY()+plus));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + plus2, this.getPosition().getY()+moins));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

        try {
            mouvements.add(new Position(this.getPosition().getX() + moins2, this.getPosition().getY()+moins));
        }
        catch (PositionInvalideException e) {
            // Ne fait rien, empêche simplement de planter si la position est invalide, donc non crée
        }

//        Position hautDroit =  new Position(this.getPosition().getX() + plus, this.getPosition().getY()+plus2);
//        Position hautGauche =  new Position(this.getPosition().getX() + moins, this.getPosition().getY()+plus2);
//        Position basDroit =  new Position(this.getPosition().getX() + plus, this.getPosition().getY()+moins2);
//        Position basGauche =  new Position(this.getPosition().getX() + moins, this.getPosition().getY()+moins2);
//
//
//
//        mouvements.add(hautDroit);
//        mouvements.add(hautGauche);
//        mouvements.add(basDroit);
//        mouvements.add(basGauche);
//
//        mouvements.add(new Position(hautDroit.getY(), hautDroit.getX()));
//        mouvements.add(new Position(hautGauche.getY(), hautGauche.getX()));
//        mouvements.add(new Position(basGauche.getY(), basGauche.getX()));
//        mouvements.add(new Position(basDroit.getY(), basDroit.getX()));

        return mouvements;
    }
}
