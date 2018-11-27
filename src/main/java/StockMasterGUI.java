import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

/**
 * App with GUI in which user can type in a company’s stock symbol and get raw prediction of
 *  future stock price movement based on real-time and historical stock data and an emoji
 *  which reflects sentiment of news surrounding that company
 * @author Zhenghua (Calvin) Chen
 * @author 
 * @author 
 */
public class StockMasterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JTextField textField;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	/**
	 * constructor which sets up the frame and adds action listeners to the buttons
	 */
	public StockMasterGUI() {
		createComponents();
		createListeners();
	}

	/**
	 * method for setting up the frame
	 */
	private void createComponents() {
		setSize(400, 600);
		setTitle("StockMaster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		label1 = new JLabel("Enter the stock code: ");
		label2 = new JLabel("Please select a time step: ");
		textField = new JTextField(10);
		button1 = new JButton("Search");
		button2 = new JButton("Daily");
		button3 = new JButton("Weekly");
		button4 = new JButton("Monthly");
		button5 = new JButton("Quarterly");

		panel.add(label1);
		panel.add(textField);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);

		add(panel);
		setVisible(true);
	}

	/**
	 * method for adding action listeners to the buttons
	 */
	private void createListeners() {
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Search clicked");
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Daily clicked");
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Weekly clicked");
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Monthly clicked");
			}
		});

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Quarterly clicked");
			}
		});
	}

	/**
	 * main() method which creates an instance of the StockMasterGUI class
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StockMasterGUI frame = new StockMasterGUI();
			}
		});
	}
}