import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Button2Listener implements ActionListener {
	
	public Button2Listener() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("I've been clicked!");
		
	}
}