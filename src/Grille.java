import java.util.ArrayList;

/**
 * Il s'agit du modèle de notre grille principale
 *
 * @author Orann
 */
public class Grille {
	/**
	 * ArrayList of Cases.
	 */
	private ArrayList<Object> grille;
	/**
	 * The Nombre colonne.
	 */
	static final int nombre_colonne = Integer.parseInt(Config.getPropValues("nombre_colonne"));
	/**
	 * The Nombre ligne.
	 */
	static final int nombre_ligne = Integer.parseInt(Config.getPropValues("nombre_ligne"));

	/**
	 * Instantiates a new Grille.
	 *
	 * @param Cases the cases
	 */
	public Grille(ArrayList<Object> Cases) {
		setGrille(Cases);
	}

	/**
	 * Gets grille.
	 *
	 * @return the grille
	 */
	public ArrayList<Object> getGrille() {
		return grille;
	}

	/**
	 * Sets grille.
	 *
	 * @param grille the grille
	 */
	public void setGrille(ArrayList<Object> grille) {
		this.grille = grille;
	}
}
