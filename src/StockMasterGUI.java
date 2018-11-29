import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import com.google.gson.Gson;
import java.io.IOException;

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
	private final String imageLocation1 = "pic1.png";
	private final String imageLocation2 = "pic2.png";
	private final String imageLocation3 = "pic3.png";
	private final String imageLocation4 = "pic4.png";
	private final String imageLocation5 = "pic5.png";
	private ImageIcon icon1;
	private JLabel emojiLabel1;
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JTextField textField;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private String symbol = "GOOGL";
	private String range = "1y";

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
		

		panel = new JPanel();
		label1 = new JLabel("Enter the stock code: ");
		label2 = new JLabel("Please select a time step: ");
		textField = new JTextField(10);
		button1 = new JButton("Search");
		button2 = new JButton("Daily");
		button3 = new JButton("Monthly");
		button4 = new JButton("Quarterly");
		button5 = new JButton("Yearly");
		icon1 = new ImageIcon(imageLocation1);
		emojiLabel1 = new JLabel();
		emojiLabel1.setIcon(icon1);
		

		panel.add(label1);
		panel.add(textField);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(emojiLabel1);

		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			    symbol = textField.getText();
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Daily clicked");
				range = "1d";
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Monthly clicked");
				range = "1m";
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Quarterly clicked");
				range = "3m";
			}
		});

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Yearly clicked");
				range = "1y";
			}
		});
	}
	
	private void getStockData (String city) {
		String jsonText = "";
		try {
			URL iex = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/chart/" + range);
			URLConnection iexAPI = iex.openConnection();
			BufferedReader in = new BufferedReader(
				new InputStreamReader(
                        iexAPI.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				jsonText += inputLine;
			}

			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		System.out.println(jsonText);
		Gson gson = new Gson();
		DailyStockData[] stockDataArray = gson.fromJson(jsonText, DailyStockData[].class);

		for (int i = 0; i < stockDataArray.length; i++) {
			System.out.println(stockDataArray[i].getDate());
			System.out.println(stockDataArray[i].getOpen());
		}
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