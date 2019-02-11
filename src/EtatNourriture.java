
public enum EtatNourriture {
	FRAICHE("La nourriture est fraîche."),
    PERIMEE("La nourriture est perimée.");

    private String name = "";

    EtatNourriture(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
