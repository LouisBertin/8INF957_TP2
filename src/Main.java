import java.util.ArrayList;

/**
 * The type Main.
 */
public class Main {

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
            for(Pigeon p : pigeons){
                p.run();
            }
        }
    }
}
