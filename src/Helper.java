import java.util.ArrayList;
import java.util.Random;

/**
 * The type Helper
 * Class where we put fonctionnal stuff
 */
public class Helper {

    /**
     * The constant probabilite.
     */
    public static double probabilite = 0;
    /**
     * The constant chance.
     */
    public static double chance = 0;

    /**
     * Instantiates a new Helper.
     */
    public Helper() {
    }

    /**
     * Wake up pigeons.
     */
    public static void wakeUpPigeons() {
        ArrayList<Pigeon> pigeons = Grille.getInstance().getAllByClass(Pigeon.class);

        while(true) {
            probabilite = Math.random()*0.5;
            Random r = new Random();
            chance = r.nextDouble();
            for (Pigeon p : pigeons) {
                p.run();
            }
            if (pigeons.get(0).getEtat().equals(EtatPigeon.ENDORMI)) {
                if (chance < probabilite) {
                    for (Pigeon p : pigeons) {
                        p.setEtat(EtatPigeon.REVEILLE);
                    }
                    Grille.getInstance().shufflePigeonEtCase();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
