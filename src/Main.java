import java.util.ArrayList;
import java.util.Random;

/**
 * The type Main.
 */
public class Main {


    public static double probabilite = 0;
    public static double chance = 0;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        ArrayList<Pigeon> pigeons = new ArrayList<>();
        for(Object a : Grille.getInstance().getGrille()){
            if(a instanceof Pigeon){
                pigeons.add((Pigeon) a);
            }
        }

        while(true){
            probabilite = Math.random();
            Random r = new Random();
            chance = r.nextDouble();
            for(Pigeon p : pigeons){
                p.run();
            }
            if(pigeons.get(0).getEtat().equals(EtatPigeon.ENDORMI)){
                if(chance < probabilite){
                    for(Pigeon p : pigeons){
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
