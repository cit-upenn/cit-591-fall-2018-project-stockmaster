import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockMasterGUI {

	public static void main(String[] args) {
		
		JLabel label1 = new JLabel("Enter the stock code: ");
		JLabel label2 = new JLabel("Please select a time step: ");
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JTextField textField = new JTextField(10);
		
		frame.setSize(400, 600);
		frame.setTitle("StockMaster");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1.setText("Search");
		button2.setText("Daily");
		button3.setText("Weekly");
		button4.setText("Monthly");
		button5.setText("Quarterly");
		Button1Listener button1Listener = new Button1Listener(label1, textField);
		Button2Listener button2Listener = new Button2Listener();
		button1.addActionListener(button1Listener);	
		
		panel.add(label1);
		panel.add(textField);
		panel.add(button1);
		panel.add(label2);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.add(panel);
		
		frame.setVisible(true);
		
	}
}