import javax.swing.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The type Nourriture.
 */
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

	/**
	 * Instantiates a new Nourriture.
	 *
	 * @param coordinateX the coordinate x
	 * @param coordinateY the coordinate y
	 */
	public Nourriture(int coordinateX, int coordinateY) {
		etat = EtatNourriture.FRAICHE;
		t = new Date();
		this.setText("Nourriture");

		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	/**
	 * Gets etat.
	 *
	 * @return the etat
	 */
	public EtatNourriture getEtat() {
		return etat;
	}

	/**
	 * Sets etat.
	 *
	 * @param etat the etat
	 */
	public void setEtat(EtatNourriture etat) {
		this.etat = etat;
		if(etat == EtatNourriture.PERIMEE)
			this.setText("Périmée");
		else
			this.setText("Nourriture");
	}

	/**
	 * Check etat nourriture.
	 *
	 * @param timeUnit the time unit
	 */
	public void checkEtatNourriture(TimeUnit timeUnit){
		Date date = new Date();
		long diff = date.getTime() - getT().getTime();
		diff = timeUnit.convert(diff, TimeUnit.MILLISECONDS);
		if(diff > 10000){
			setEtat(EtatNourriture.PERIMEE);
		}
	}

	/**
	 * Gets t.
	 *
	 * @return the t
	 */
	public Date getT() {
		return t;
	}

	/**
	 * Sets t.
	 *
	 * @param t the t
	 */
	public void setT(Date t) {
		this.t = t;
	}

	/**
	 * Gets coordinate x.
	 *
	 * @return the coordinate x
	 */
	public int getCoordinateX() {
		return coordinateX;
	}

	/**
	 * Sets coordinate x.
	 *
	 * @param coordinateX the coordinate x
	 */
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	/**
	 * Gets coordinate y.
	 *
	 * @return the coordinate y
	 */
	public int getCoordinateY() {
		return coordinateY;
	}

	/**
	 * Sets coordinate y.
	 *
	 * @param coordinateY the coordinate y
	 */
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
}
