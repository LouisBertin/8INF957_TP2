/**
 * The enum Etat pigeon.
 */
public enum EtatPigeon {
    /**
     * Sleep.
     */
    ENDORMI("Le pigeon est endormi."),
    /**
     * Awake.
     */
    REVEILLE("Le pigeon est réveillé.");

    /**
     * Name attribute.
     */
    private String name = "";

    /**
     * Construct.
     *
     * @param name
     */
    EtatPigeon(String name) {
        this.name = name;
    }

    /**
     * To string.
     */
    public String toString() {
        return name;
    }
}
