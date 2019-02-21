import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 * Il s'agit du modèle de notre grille principale
 *
 * @author Orann
 */
public class Grille extends Observable {
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
		setChanged();
		notifyObservers();
	}

	public void deplacementPigeon(Pigeon pigeon, int to) {
		int index = Grille.getInstance().getGrille().indexOf(pigeon);
		Object objetTo = Grille.getInstance().getGrille().get(index+to);
		if(objetTo instanceof Nourriture) {
			replace(objetTo, new Case(0, 0));
		} else {
			Collections.swap(Grille.getInstance().getGrille(), index, index+to);
			setChanged();
			notifyObservers();
		}

	}

	/*public ArrayList<Object> recupererInstance(String c){
		ArrayList<Object> objects = new ArrayList<>();
		try {
			Class classe = Class.forName(c);
			for(Object a : grille){
				if(a instanceof classe){
					objects.add(a);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/

}
