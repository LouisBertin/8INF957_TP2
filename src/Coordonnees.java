/**
 * C'est une classe outil permettant de faciliter l'accès à une donnée dans la grille
 * @author Orann
 *
 */
public class Coordonnees {
	private int x;
	private int y;
	
	public Coordonnees(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
