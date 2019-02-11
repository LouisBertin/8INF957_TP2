
public class Nourriture extends Case{
	private EtatNourriture etat;

	public Nourriture(Coordonnees coordonnees) {
		super(coordonnees);
		etat = EtatNourriture.FRAICHE;
	}
	
	public Nourriture(int x, int y) {
		super(x, y);
		etat = EtatNourriture.FRAICHE;
	}
}
