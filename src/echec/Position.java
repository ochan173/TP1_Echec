package echec;

/**
 * Classe pour une position de base.
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Position {
    private int m_x;
    private int m_y;

    public int getX() {
        return m_x;
    }

    public int getY() {
        return m_y;
    }

    /**
     * Constructeur pour une position, vérifie aussi que les coordonnées passées sont entier positif et inférieur à 8.
     * @param p_x position X utiliser par la position.
     * @param p_y position Y utiliser par la position.
     * @throws PositionInvalideException Si la position est invalide, cette exception sera levée.
     */
    public Position(int p_x, int p_y) throws PositionInvalideException {
        if(p_x >= 0 && p_y >= 0 && p_x <= 7 && p_y <= 7) {
            m_x = p_x;
            m_y = p_y;
        }
        else {
            throw new PositionInvalideException("La position est invalide");
        }
    }

    /**
     * Méthode pour modifier une position.
     *
     * @param p_position nouvelle position.
     */
    public void modifierPosition(Position p_position) {
        m_x = p_position.getX();
        m_y = p_position.getY();
    }
}
