import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Fenetre.
 */
public class Fenetre extends JFrame {

    /**
     * Instantiates a new Fenetre.
     */
    public Fenetre() {

        this.setTitle("Les pigeons");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setSize(1000, 500);
        this.setContentPane(panel);
        this.setLayout(new GridLayout(10, 10));
        JButton[][] boutons = new JButton[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boutons[i][j] = new Case(i, j);

                panel.add(boutons[i][j]);
            }
        }

        // TODO : créer l'objet grille à partir de l'Array de boutons

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

}
