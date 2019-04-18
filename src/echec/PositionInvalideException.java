package echec;

/**
 * Classe d'exception personnalisée pour les positions.
 * Elle sera utilisé lors de la création de position invalide.
 */
public class PositionInvalideException extends IllegalArgumentException {
    PositionInvalideException(String p_message) {
        super(p_message);
    }
}

