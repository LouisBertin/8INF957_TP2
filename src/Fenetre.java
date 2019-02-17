import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

/**
 * The type Fenetre.
 */
public class Fenetre extends JFrame {

    /**
     * Instantiates a new Fenetre.
     */
    public Fenetre() {

        // create panel
        this.setTitle("Les pigeons");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setSize(1000, 500);
        this.setContentPane(panel);
        this.setLayout(new GridLayout(10, 10));
        JButton[][] boutons = new JButton[10][10];

        // create all components
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boutons[i][j] = (index <= 95) ? new Case(i, j) : new Pigeon(i, j);
                index++;
            }
        }

        // convert components to grille
        ArrayList componentsSorted = this.convertComponentsToGrille(boutons);

        // build panel
        for (int i = 0; i < componentsSorted.size(); i++) {
            JButton button = (JButton) componentsSorted.get(i);
            panel.add(button);
        }

        // display window
        this.setVisible(true);
        this.refresh();
    }

    /**
     * Refresh.
     */
    public void refresh() {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                //System.out.println(3 + " seconds");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, new Date(), 3000);
    }

    /**
     * Convert components array to Grille.
     * @param boutons
     */
    private ArrayList convertComponentsToGrille(JButton[][] boutons) {
        ArrayList<Object> items = new ArrayList<>();

        // build arrayList
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Object item = boutons[i][j];
                items.add(item);
            }
        }

        // swap objects
        for (int i = 0; i <= 3; i++) {
            //TODO: si le programme crash ici c'est que le même nombre random est généré.. il faut le gérer
            Random r = new Random();
            int result = r.nextInt(96);
            int[] caseCoordinates = new int[2];

            System.out.println(result);

            Case Case = (Case) items.get(result);
            Pigeon pigeon = (Pigeon) items.get(96 + i);

            // save case coordinates
            caseCoordinates[0] = Case.getCoordinateX();
            caseCoordinates[1] = Case.getCoordinateY();

            // exchange coordinates
            Case.setCoordinateX(pigeon.getCoordinateX());
            Case.setCoordinateX(pigeon.getCoordinateY());
            pigeon.setCoordinateX(caseCoordinates[0]);
            pigeon.setCoordinateX(caseCoordinates[1]);

            // swap items in collections
            Collections.swap(items, result, 96 + i);
        }

        return items;
    }

}
