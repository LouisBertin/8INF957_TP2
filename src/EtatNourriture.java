/**
 * The enum Etat nourriture.
 */
public enum EtatNourriture {
    /**
     * Fresh state
     */
    FRAICHE("La nourriture est fraîche."),
    /**
     * Expired state
     */
    PERIMEE("La nourriture est perimée.");

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
