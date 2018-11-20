import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Button2Listener implements ActionListener {

	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	public Button2Listener(JButton button2, JButton button3, JButton button4, JButton button5) {
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
		this.button5 = button5;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("I've been clicked!");
		
	}
}