
public class Pigeon extends Case{
	private EtatPigeon etat;

	public Pigeon(Coordonnees coordonnees) {
		super(coordonnees);
		etat = EtatPigeon.REVEILLE;
	}
	
	public Pigeon(int x, int y) {
		super(x, y);
		etat = EtatPigeon.REVEILLE;
	}

}
