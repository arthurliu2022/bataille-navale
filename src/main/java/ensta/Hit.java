package ensta;
import java.util.NoSuchElementException;
import ship.*;

public enum Hit {
    MISS(-1, "Manqué"),
    STRIKE(-2, "Touché"),
    DESTROYER(2, "Destroyer"),
    SUBMARINE(3, "Sous-marin"),
    BATTLESHIP(4, "Cuirassé"),
    CARRIER(5, "Porte-avion");

    /* ***
     * Attributs
     */
    private int value;
    private String label;

    /* ***
     * Constructeur
     */
    Hit(int value, String label) {
        this.value = value;
        this.label = label;
    }

    /* ***
     * Méthodes
     */
    public static Hit fromInt(int value) {
        for (Hit hit : Hit.values()) {
            if (hit.value == value) {
                return hit;
            }
        }
        throw new NoSuchElementException("no enum for value " + value);
    }

    public String toString() {
        return this.label;
    }

    public int toInt() {
        return this.value;
    }
};
