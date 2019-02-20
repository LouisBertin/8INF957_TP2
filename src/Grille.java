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

	/** Instance unique non préinitialisée */
	private static Grille INSTANCE = null;

	/**
	 * Instantiates a new Grille.
	 *
	 */
	private Grille() {
	}

	/**
	 * Return singleton.
	 *
	 * @return instance
	 */
	public static Grille getInstance()
	{
		if (INSTANCE == null) {
			INSTANCE = new Grille();
		}
		return INSTANCE;
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

	/**
	 * Replace.
	 *
	 * @param objectToRemove the object to remove
	 * @param newObject      the new object
	 */
	public void replace(Object objectToRemove, Object newObject) {
		int index = getGrille().indexOf(objectToRemove);
		getGrille().set(index, newObject);
	}

}
