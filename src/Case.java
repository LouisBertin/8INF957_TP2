import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Case.
 */
public class Case extends JButton implements ActionListener {

	/**
	 * X coordinate
	 */
	private int coordinateX;
	/**
	 * Y coordinate
	 */
	private int coordinateY;

	private Nourriture nourriture;

	/**
	 * Instantiates a new Case.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Case(int x, int y) {
		setCoordinateX(x);
		setCoordinateY(y);

		this.addActionListener(this);
	}

    /**
     * Click on Case
     * @param e
     */
	public void actionPerformed(ActionEvent e) {
		this.setText("food");
		this.setOpaque(true);
		this.setBackground(Color.blue);
		nourriture = new Nourriture(getCoordinateX(),getCoordinateY());
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

	public Nourriture getNourriture() {
		return nourriture;
	}

	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}

}
