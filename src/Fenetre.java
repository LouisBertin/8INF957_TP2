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

        // initialize panel
        this.init();

        // display window
        this.setVisible(true);
        this.refresh();
    }

    /**
     * Initialize window.
     */
    private void init() {
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

        // build panel
        this.buildPanel(boutons, panel);
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
     * Build panel.
     * @param boutons
     * @param panel
     */
    private void buildPanel(JButton[][] boutons, JPanel panel) {
        // convert components to grille
        ArrayList<Object> componentsSorted = this.convertComponentsToGrille(boutons);

        // build panel
        for (int i = 0; i < componentsSorted.size(); i++) {
            JButton button = (JButton) componentsSorted.get(i);
            panel.add(button);
        }

        // create grille singleton
        Grille.getInstance().setGrille(componentsSorted);
    }

    /**
     * Convert panel to grille.
     * @param boutons
     * @return
     */
    private ArrayList<Object> convertComponentsToGrille(JButton[][] boutons) {
        ArrayList<Object> items = new ArrayList<>();

        // build arrayList
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Object item = boutons[i][j];
                items.add(item);
            }
        }

        // fetch random values
        int[] random = uniqueRandomNumbers(96, 4);
        // swap objects
        for (int i = 0; i <= 3; i++) {
            int[] caseCoordinates = new int[2];

            Case Case = (Case) items.get(random[i]);
            Pigeon pigeon = (Pigeon) items.get(96 + i);

            // save case coordinates
            caseCoordinates[0] = Case.getCoordinateX();
            caseCoordinates[1] = Case.getCoordinateY();

            // exchange coordinates
            Case.setCoordinateX(pigeon.getCoordinateX());
            Case.setCoordinateY(pigeon.getCoordinateY());
            pigeon.setCoordinateX(caseCoordinates[0]);
            pigeon.setCoordinateY(caseCoordinates[1]);

            // swap items in collections
            Collections.swap(items, random[i], 96 + i);
        }

        return items;
    }

    /**
     * Generate unique random numbers.
     * @param range
     * @param bound
     * @return
     */
    private static int[] uniqueRandomNumbers(int range, int bound) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] numbers = new int[bound];

        for (int i=1; i < range; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i=0; i < bound; i++) {
            numbers[i] = list.get(i);
        }

        return numbers;
    }

}
