import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * The type Pigeon.
 */
public class Pigeon extends JButton implements Runnable {

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
     * Gets etat.
     *
     * @return the etat
     */
    public EtatPigeon getEtat() {
        return etat;
    }

    /**
     * Sets etat.
     *
     * @param etat the etat
     */
    public void setEtat(EtatPigeon etat) {
        this.etat = etat;
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

    @Override
    public void run() {

        ArrayList<Nourriture> nourritures = new ArrayList<>();
        // remove expired foods
        for (Object a : Grille.getInstance().getGrille()) {
            if (a instanceof Nourriture) {
                Nourriture n = (Nourriture) a;
                n.checkEtatNourriture(TimeUnit.MILLISECONDS);

                if (!n.getEtat().equals(EtatNourriture.PERIMEE)) {
                    nourritures.add((Nourriture) a);
                }
            }
        }

        if (nourritures.isEmpty()) {
            setEtat(EtatPigeon.ENDORMI);
        } else {
            setEtat(EtatPigeon.REVEILLE);
            Nourriture choisi = nourritures.get(0);

            //TODO: fonctionne aléatoirement
            for (Nourriture nourriture : nourritures) {
                if (nourriture.getT().after(choisi.getT())) {
                    choisi = nourriture;
                } else {
                    nourriture.setEtat(EtatNourriture.FRAICHE);
                }
            }

            int indexNourriture = Grille.getInstance().getGrille().indexOf(choisi);

            int y = indexNourriture % 10;
            int x = indexNourriture / 10;

            if (x < getCoordinateX()) {
                Grille.getInstance().deplacementPigeon(this, -10);
            } else if (x > getCoordinateX()) {
                Grille.getInstance().deplacementPigeon(this, 10);
            } else if (y < getCoordinateY()) {
                Grille.getInstance().deplacementPigeon(this, -1);
            } else if (y > getCoordinateY()) {
                Grille.getInstance().deplacementPigeon(this, 1);
            }

        }
    }
}
