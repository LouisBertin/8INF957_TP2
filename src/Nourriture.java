import java.util.Date;
import java.util.Timer;

public class Nourriture{

	private EtatNourriture etat;

	private Date t;

	public Nourriture(Coordonnees coordonnees) {
		etat = EtatNourriture.FRAICHE;
	}

	public Nourriture(int x, int y) {
		etat = EtatNourriture.FRAICHE;
		t = new Date();
	}

	public EtatNourriture getEtat() {
		return etat;
	}

	public void setEtat(EtatNourriture etat) {
		this.etat = etat;
	}

	public Date getT() {
		return t;
	}

	public void setT(Date t) {
		this.t = t;
	}

}
