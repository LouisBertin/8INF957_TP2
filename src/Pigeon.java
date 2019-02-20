import javax.swing.*;
import java.util.ArrayList;

/**
 * The type Pigeon.
 */
public class Pigeon extends JButton {
	private EtatPigeon etat;
	/**
	 * X coordinate
	 */
	private int coordinateX;
	/**
	 * Y coordinate
	 */
	private int coordinateY;

	/**
	 * Instantiates a new Pigeon.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Pigeon(int x, int y) {
		etat = EtatPigeon.REVEILLE;

		this.setText("pigeon");
		setCoordinateX(x);
		setCoordinateY(y);

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

/*	@Override
	public void run() {
		ArrayList<Object> grille = Grille.getInstance().getGrille();
		ArrayList<Case> nourritures = new ArrayList<>();
		for(Object a : grille){
			if(a instanceof Case){
				if(!((Case) a).getNourriture().equals(null)){
					if(((Case) a).getNourriture().getEtat().equals(EtatNourriture.FRAICHE)){
						nourritures.add((Case) a);
					}
				}
			}
		}

		Case choisi = null;
		for( Case nourriture  : nourritures) {
			if(nourriture.getNourriture().getT().before(choisi.getNourriture().getT()) || choisi.equals(null)){
					choisi = nourriture;
			}
		}
	}*/
}
