import java.util.ArrayList;

/**
 * Il s'agit du modèle de notre grille principale
 * @author Orann
 *
 */
public class Grille {
	private ArrayList<ArrayList<Object>> grille;
	private int nombre_colonne;
	private int nombre_ligne;
	
	public Grille(int nombre_colonne, int nombre_ligne) {
		this.grille = new ArrayList<ArrayList<Object>>();
		this.nombre_colonne = nombre_colonne;
		this.nombre_ligne = nombre_ligne;
	}

	public int getNombre_colonne() {
		return nombre_colonne;
	}

	public int getNombre_ligne() {
		return nombre_ligne;
	}
}
