import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements MouseListener {

    public Fenetre() {

        this.setTitle("Les pigeons");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setSize(1000, 500);
        this.setContentPane(panel);
        this.setLayout(new GridLayout(20, 20));
        JButton[][] boutons = new JButton[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.white);
                boutons[i][j].setBorderPainted(false);
                panel.add(boutons[i][j]);
            }
        }


        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                boutons[i][j].addMouseListener(this);
            }
        }

        this.setVisible(true);


    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) { }

    public void mousePressed(MouseEvent event) { }

    public void mouseReleased(MouseEvent event) { }


}
