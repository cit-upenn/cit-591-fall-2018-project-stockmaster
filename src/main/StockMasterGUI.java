package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
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

import org.json.JSONException;
import org.knowm.xchart.SwingWrapper;

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

	private static final long serialVersionUID = 1;
	private final String imgLoc1 = "pic1.png";
	private final String imgLoc2 = "pic2.png";
	private final String imgLoc3 = "pic3.png";
	private final String imgLoc4 = "pic4.png";
	private final String imgLoc5 = "pic5.png";
	private ImageIcon imgIcon;
	private JLabel emojiLabel;
	private JPanel panel;
	private JLabel stockLabel;
	private JLabel rangeLabel;
	private JTextField textField;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private String symbol = "GOOGL";
	private String range = "1y";
	private double sentiment = 0;
	private JPanel graphPanel;
    //try aapl
    private SentimentAnalysis sa = new SentimentAnalysis(symbol);
    private IEXTradingPrices price = new IEXTradingPrices();

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
		stockLabel = new JLabel("Enter the stock code: ");
		rangeLabel = new JLabel("Please select a time step: ");
		textField = new JTextField(10);
		button1 = new JButton("Search");
		button2 = new JButton("Daily");
		button3 = new JButton("Monthly");
		button4 = new JButton("Quarterly");
		button5 = new JButton("Yearly");
		emojiLabel = new JLabel();
		graphPanel = new JPanel();
		
		
		DataGraph dg = new DataGraph();
		try {
			graphPanel = dg.drawGraph("aapl", "ytd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (sentiment > 0.67)
			emojiLabel.setIcon(new ImageIcon(imgLoc1));
		else if (sentiment > 0.33)
			emojiLabel.setIcon(new ImageIcon(imgLoc2));
		else if (sentiment > -0.33)
			emojiLabel.setIcon(new ImageIcon(imgLoc3));
		else if (sentiment > -0.67)
			emojiLabel.setIcon(new ImageIcon(imgLoc4));
		else
			emojiLabel.setIcon(new ImageIcon(imgLoc5));

		panel.add(stockLabel);
		panel.add(textField);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(emojiLabel);
		
		add(panel);
		add(graphPanel);
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
			    try {
		            price.getStockPrice(symbol, range);
		            sentiment = sa.runSentimentAnalysis();
		            createComponents();
		        } catch (IOException excep) {
		        	excep.printStackTrace();
		        } catch (JSONException e1) {
		        	e1.printStackTrace();
		        }
			    
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Daily clicked");
				range = "1d";
				try {
		            price.getStockPrice(symbol, range);
		            sentiment = sa.runSentimentAnalysis();
		        } catch (IOException excep) {
		        	excep.printStackTrace();
		        }
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Monthly clicked");
				range = "1m";
				try {
		            price.getStockPrice(symbol, range);
		            sentiment = sa.runSentimentAnalysis();
		        } catch (IOException excep) {
		        	excep.printStackTrace();
		        }
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Quarterly clicked");
				range = "3m";
				try {
		            price.getStockPrice(symbol, range);
		            sentiment = sa.runSentimentAnalysis();
		        } catch (IOException excep) {
		        	excep.printStackTrace();
		        }
			}
		});

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Yearly clicked");
				range = "1y";
				try {
		            price.getStockPrice(symbol, range);
		            sentiment = sa.runSentimentAnalysis();
		        } catch (IOException excep) {
		        	excep.printStackTrace();
		        }
			}
		});
	}
	
	private void getStockData (String city) throws IOException {
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
		StockDataYearly[] stockDataArray = gson.fromJson(jsonText, StockDataYearly[].class);

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