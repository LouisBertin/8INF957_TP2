import javax.swing.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Nourriture extends JButton {

	private EtatNourriture etat;
	private Date t;
	/**
	 * X coordinate
	 */
	private int coordinateX;
	/**
	 * Y coordinate
	 */
	private int coordinateY;

	public Nourriture(int coordinateX, int coordinateY) {
		etat = EtatNourriture.FRAICHE;
		t = new Date();
		this.setText("bouffe");

		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public EtatNourriture getEtat() {
		return etat;
	}

	public void setEtat(EtatNourriture etat) {
		this.etat = etat;
		if(etat == EtatNourriture.PERIMEE)
			this.setText("Périmée");
		else
			this.setText("bouffe");
	}

	public void checkEtatNourriture(TimeUnit timeUnit){
		Date date = new Date();
		long diff = date.getTime() - getT().getTime();
		diff = timeUnit.convert(diff, TimeUnit.MILLISECONDS);
		if(diff > 10000){
			setEtat(EtatNourriture.PERIMEE);
		}
	}

	public Date getT() {
		return t;
	}

	public void setT(Date t) {
		this.t = t;
	}

}
