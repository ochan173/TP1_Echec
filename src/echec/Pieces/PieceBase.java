package echec.Pieces;


import echec.Position;

/**
 * Classe de base pour toutes les pièces.
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public abstract class PieceBase {
    /**
     * Couleur disponible pour les pièces d'un jeu d'échec.
     */
    public enum Couleur {BLANC, NOIR}

    /**
     * Énum des types de pièce disponibles.
     */
    public enum TypePiece {ROI, REINE, TOUR, CAVALIER, PION, FOU}

    protected Position m_position;
    private Couleur m_couleur;
    private TypePiece m_type;

    public Couleur getCouleur() {
        return m_couleur;
    }

    public Position getPosition() {
        return m_position;
    }

    public TypePiece getType() {
        return m_type;
    }

    /**
     * Constructeur de base pour une pièce.
     * @param p_couleur la couleur que la pièce recevera.
     * @param p_type Type de la pièce.
     */
    protected PieceBase(Couleur p_couleur, TypePiece p_type) {
        m_couleur = p_couleur;
        m_type = p_type;
    }

    /**
     * Déplace la pièce avec une nouvelle position.
     * @param p_nouvellePosition la nouvelle position pour la pièce.
     */
    protected void deplacer(Position p_nouvellePosition) {
        m_position.modifierPosition(p_nouvellePosition);
    }

    /**
     * Détermine les déplacements qui sont valide pour la pièce.
     * @return si le déplacement est valide.
     */
    protected abstract boolean deplacementValide();

    /**
     * Permet de retourner toutes les positions (sans contraintes) d'une pièce
     * en fonction du type de mouvement qu'elle possède.
     * @return Une collection de positions.
     */
    public abstract Position[] MouvementPossible();
}
