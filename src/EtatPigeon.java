
public enum EtatPigeon {
	ENDORMI("Le pigeon est endormi."),
    REVEILLE("Le pigeon est r�veill�.");

    private String name = "";

    EtatPigeon(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
