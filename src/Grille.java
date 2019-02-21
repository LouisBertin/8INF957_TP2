import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

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
	 * @return instance instance
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

	/**
	 * Deplacement pigeon.
	 *
	 * @param pigeon the pigeon
	 * @param to     destination index
	 */
	public void deplacementPigeon(Pigeon pigeon, int to) {
		int index = Grille.getInstance().getGrille().indexOf(pigeon);
		Object objetTo = Grille.getInstance().getGrille().get(index+to);
		int[] destination = new int[2];

		if(objetTo instanceof Nourriture) {
			int x = ((Nourriture) objetTo).getCoordinateX();
			int y = ((Nourriture) objetTo).getCoordinateY();

			try {
				replace(objetTo, new Case(x, y));
			} catch(Exception e) {
				System.out.println("Exception "+e+" occured when a pigeon eats food");
			}
		} else {
			if (objetTo instanceof Case) {
				// store destination coordinates
				destination[0] = ((Case) objetTo).getCoordinateX();
				destination[1] = ((Case) objetTo).getCoordinateY();
				// swap items
				try {
					Collections.swap(Grille.getInstance().getGrille(),
							index, index+to);
					// swap coordinates
					((Case) objetTo).setCoordinateX(pigeon.getCoordinateX());
					((Case) objetTo).setCoordinateY(pigeon.getCoordinateY());
					pigeon.setCoordinateX(destination[0]);
					pigeon.setCoordinateY(destination[1]);
				} catch (Exception e) {
					System.out.println("Exception "+e+" occured when a pigeon moves");
				}

				// refresh display
				try {
					setChanged();
					notifyObservers();
				} catch (Exception e) {
					System.out.println("Exception "+e+" occured when the display refreshes");
				}

			}
		}
	}

	/**
	 * Shuffle pigeon et case.
	 */
	public void shufflePigeonEtCase() {
		ArrayList<Object> pigeons = getAllByClass(Pigeon.class);
		ArrayList<Object> Cases = getAllByClass(Case.class);

		Random rand = new Random();
		int randomNum = rand.nextInt(Cases.size());

		for (int i = 0; i < pigeons.size(); i++) {
			int[] destination = new int[2];
			Case Case = (Case) Cases.get(randomNum);
			Pigeon pigeon = (Pigeon) pigeons.get(i);
			// store dest coordinates
			destination[0] = Case.getCoordinateX();
			destination[1] = Case.getCoordinateY();
			// swap coordinates
			Case.setCoordinateX(pigeon.getCoordinateX());
			Case.setCoordinateY(pigeon.getCoordinateY());
			pigeon.setCoordinateX(destination[0]);
			pigeon.setCoordinateY(destination[1]);
			// swap items
			int pigeonIndex = getGrille().indexOf(pigeon);
			int caseIndex = getGrille().indexOf(Case);
			Collections.swap(getGrille(), pigeonIndex, caseIndex);
		}
	}

	/**
	 * Gets all by class.
	 *
	 * @param Class the class
	 * @return the all by class
	 */
	public ArrayList<Object> getAllByClass(Class Class) {
		ArrayList<Object> results = new ArrayList<>();

		for (Object objet : getGrille()) {
			if (Class.isInstance(objet)) {
				results.add(objet);
			}
		}

		return results;
	}

}
