
public class Nourriture{
	private EtatNourriture etat;

	public Nourriture(Coordonnees coordonnees) {
		etat = EtatNourriture.FRAICHE;
	}

	public Nourriture(int x, int y) {
		etat = EtatNourriture.FRAICHE;
	}
}
