package echec.Pieces;

import echec.Position;

import java.util.ArrayList;

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

        int xPlus = 1;
        int xMoins = -1;
        int yPlus = 2;
        int yMoins = -2;

        Position hautDroit =  new Position(this.getPosition().getX() + xPlus, this.getPosition().getY()+yPlus);
        Position hautGauche =  new Position(this.getPosition().getX() + xMoins, this.getPosition().getY()+yPlus);
        Position basDroit =  new Position(this.getPosition().getX() + xPlus, this.getPosition().getY()+yMoins);
        Position basGauche =  new Position(this.getPosition().getX() + xMoins, this.getPosition().getY()+yMoins);

        mouvements.add(hautDroit);
        mouvements.add(hautGauche);
        mouvements.add(basDroit);
        mouvements.add(basGauche);

        mouvements.add(new Position(hautDroit.getY(), hautDroit.getX()));
        mouvements.add(new Position(hautGauche.getY(), hautGauche.getX()));
        mouvements.add(new Position(basGauche.getY(), basGauche.getX()));
        mouvements.add(new Position(basDroit.getY(), basDroit.getX()));

        return mouvements;
    }
}
