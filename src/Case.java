import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Case.
 */
public class Case extends JButton implements ActionListener {

	/**
	 * Instantiates a new Case.
	 */
	public Case() {
		this.addActionListener(this);
	}

    /**
     * Click on Case
     * @param e
     */
	public void actionPerformed(ActionEvent e) {
		this.setText("food");
		this.setOpaque(true);
		this.setBackground(Color.blue);
	}

}
