import java.util.ArrayList;

/**
 * Il s'agit du modèle de notre grille principale
 * @author Orann
 *
 */
public class Grille {
	private ArrayList<Case> grille;
	static final int nombre_colonne = Integer.parseInt(Config.getPropValues("nombre_colonne"));
	static final int nombre_ligne = Integer.parseInt(Config.getPropValues("nombre_ligne"));

	public Grille(int nombre_colonne, int nombre_ligne) {
		this.grille = new ArrayList<Case>();
	}

}
