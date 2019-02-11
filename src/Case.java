
public abstract class Case {
	private Coordonnees coordonnees;

	public Case(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	public Case(int x, int y) {
		this.coordonnees = new Coordonnees(x, y);
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}
}
