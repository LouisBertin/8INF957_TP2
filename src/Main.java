
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
        // init game
        Fenetre fenetre = new Fenetre();
        // pigeons awakening
        try {
        	Helper.wakeUpPigeons();
        } catch (Exception e) {
            System.out.println("Exception " + e + " occured when we wake up the pigeons");
        }
        
    }
}
