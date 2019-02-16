/**
 * The type Pigeon.
 */
public class Pigeon {
	private EtatPigeon etat;

	public Pigeon() {
	}

	/**
	 * Instantiates a new Pigeon.
	 *
	 * @param coordonnees the coordonnees
	 */
	public Pigeon(Coordonnees coordonnees) {
		etat = EtatPigeon.REVEILLE;
	}

	/**
	 * Instantiates a new Pigeon.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Pigeon(int x, int y) {
		etat = EtatPigeon.REVEILLE;
	}

}
