
public enum EtatNourriture {
	FRAICHE("La nourriture est fra�che."),
    PERIMEE("La nourriture est perim�e.");

    private String name = "";

    EtatNourriture(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
