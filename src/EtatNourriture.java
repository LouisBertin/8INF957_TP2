/**
 * The enum Etat nourriture.
 */
public enum EtatNourriture {
    /**
     * The freshest food.
     */
    PLUS_FRAICHE("#2ecc71"),

    /**
     * Fresh state
     */
    FRAICHE("#f1c40f"),

    /**
     * Expired state
     */
    PERIMEE("#34495e");

    /**
     * The name.
     */
    private String name = "";

    /**
     * Construct.
     *
     * @param name
     */
    EtatNourriture(String name) {
        this.name = name;
    }

    /**
     * To string method
     */
    public String toString() {
        return name;
    }
}
