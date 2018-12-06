package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONException;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

/**
 * The GUI/front end of our app with which the user can interact. The GUI is integrated with the back ends to take user inputs,
 *   perform the corresponding tasks and display the results(emoji + stock chart).
 * @author Zhenghua (Calvin) Chen
 * 
 */
public class StockMasterGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final String imgLoc1 = "pic1.png";
	private final String imgLoc2 = "pic2.png";
	private final String imgLoc3 = "pic3.png";
	private final String imgLoc4 = "pic4.png";
	private final String imgLoc5 = "pic5.png";
	private JTextField textField;
	private JButton search;
	private JButton daily;
	private JButton monthly;
	private JButton quarterly;
	private JButton yearly;
	private JLabel emoji;
	private JLabel error;
	private JPanel chart;
	protected String stock = "";
	protected String time = "ytd";
	private double sentiment = 0;

	/**
	 * Constructor of the StockMasterGUI class which sets up the frame and adds action listeners to the buttons
	 */
	public StockMasterGUI() {
		createFrame();
		addListeners();
	}
	
	/**
	 * Method for setting up the frame
	 */
	private void createFrame() {
		setTitle("StockMaster");
		setSize(800, 770);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel askStock = new JLabel("Enter the stock code:");
		textField = new JTextField(10);
		search = new JButton("Search");
		daily = new JButton("Daily");
		monthly = new JButton("Monthly");
		quarterly = new JButton("Quarterly");
		yearly = new JButton("Yearly");
		emoji = new JLabel();
		error = new JLabel();
		chart = new JPanel();
		chart.setPreferredSize(new Dimension(800, 700));
		
		panel.add(askStock);
		panel.add(textField);
		panel.add(search);
		panel.add(daily);
		panel.add(monthly);
		panel.add(quarterly);
		panel.add(yearly);
		panel.add(emoji);
		panel.add(error);
		panel.add(chart);
		add(panel);
		setVisible(true);
	}
	
	/**
	 * Method for adding action listeners to the buttons
	 */
	private void addListeners() {
		// Adding an action listener to the search button
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Search clicked!");
				stock = textField.getText();
				time = "ytd";
				chart.removeAll();
				NewsAnalysis newsAnalysis = new NewsAnalysis(stock);
				DataPlot dataPlot = new DataPlot();
				try {
					sentiment = newsAnalysis.getSentiment();
					if (sentiment > 0.67)
						emoji.setIcon(new ImageIcon(imgLoc1));
					else if (sentiment > 0.33)
						emoji.setIcon(new ImageIcon(imgLoc2));
					else if (sentiment > -0.33)
						emoji.setIcon(new ImageIcon(imgLoc3));
					else if (sentiment > -0.67)
						emoji.setIcon(new ImageIcon(imgLoc4));
					else
						emoji.setIcon(new ImageIcon(imgLoc5));
					try {
						error.setText("");
						chart.add(new XChartPanel<XYChart>(dataPlot.getLongTermChart(stock, time)));
					} catch (JSONException | ParseException eJSON) {
						//eJSON.printStackTrace();
						error.setText("Data not available.");
					}
				} catch (IOException eIO) {
					//eIO.printStackTrace();
					error.setText("Invalid stock code entered. Please enter a valid stock code.");
					emoji.setIcon(new ImageIcon());
				}
				revalidate();
			}
		});
		
		// Adding an action listener to the daily button
		daily.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Daily clicked!");
				time = "1d";
				chart.removeAll();
				DataPlot stockChart = new DataPlot();
				try {
					error.setText("");
					chart.add(new XChartPanel<XYChart>(stockChart.getLongTermChart(stock, time)));
				} catch (IOException | JSONException | ParseException eIOorJSON) {
					//eIOorJSON.printStackTrace();
					error.setText("Data not available.");
				}
				revalidate();
			}
		});
		
		// Adding an action listener to the monthly button
		monthly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Monthly clicked!");
				time = "1m";
				chart.removeAll();
				DataPlot stockChart = new DataPlot();
				try {
					error.setText("");
					chart.add(new XChartPanel<XYChart>(stockChart.getLongTermChart(stock, time)));
				} catch (IOException | JSONException | ParseException eIOorJSON) {
					//eIOorJSON.printStackTrace();
					error.setText("Data not available.");
				}
				revalidate();
			}
		});
		
		// Adding an action listener to the quarterly button
		quarterly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Quarterly clicked!");
				time = "3m";
				chart.removeAll();
				DataPlot stockChart = new DataPlot();
				try {
					error.setText("");
					chart.add(new XChartPanel<XYChart>(stockChart.getLongTermChart(stock, time)));
				} catch (IOException | JSONException | ParseException eIOorJSON) {
					//eIOorJSON.printStackTrace();
					error.setText("Data not available.");
				}
				revalidate();
			}
		});
		
		// Adding an action listener to the yearly button
		yearly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Yearly clicked!");
				time = "ytd";
				chart.removeAll();
				DataPlot stockChart = new DataPlot();
				try {
					error.setText("");
					chart.add(new XChartPanel<XYChart>(stockChart.getLongTermChart(stock, time)));
				} catch (IOException | JSONException | ParseException eIOorJSON) {
					//eIOorJSON.printStackTrace();
					error.setText("Data not available.");
				}
				revalidate();
			}
		});
	}
	
	/**
	 * The main() method of the StockMasterGUI class which creates a StockMasterGUI object
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StockMasterGUI stockMasterGUI = new StockMasterGUI();
			}
		});
	}
}