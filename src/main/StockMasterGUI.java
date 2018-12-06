package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONException;
import org.knowm.xchart.XChartPanel;

/**
 * An app which gathers and graphs stock data based on user-specified time range, and runs a sentimental analysis
 *   on the news surrounding that company and displays an emoji based on the sentiment of the news
 * @author Zhenghua (Calvin) Chen
 * @author Shiqing (Jill) Liu
 * @author Qiongying (Jennifer) Jiang
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
	private JLabel error;
	private JLabel emoji;
	private JPanel graph;
	protected String stock = "aapl";
	protected String time = "ytd";
	private double sentiment = 0;

	public StockMasterGUI() {
		createFrame();
		addListeners();
	}
	
	private void createFrame() {
		setTitle("StockMaster");
		setSize(800, 800);
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
		error = new JLabel();
		emoji = new JLabel();
		graph = new JPanel();
		graph.setPreferredSize(new Dimension(800, 700));
		
		panel.add(askStock);
		panel.add(textField);
		panel.add(search);
		panel.add(daily);
		panel.add(monthly);
		panel.add(quarterly);
		panel.add(yearly);
		panel.add(error);
		panel.add(emoji);
		panel.add(graph);
		add(panel);
		setVisible(true);
	}
	
	private void addListeners() {
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Search clicked!");
				stock = textField.getText();
				SentimentAnalysis stockNews = new SentimentAnalysis(stock);
				try {
					error.setText("");
					sentiment = stockNews.runSentimentAnalysis();
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
					DataGraph stockGraph = new DataGraph();
					graph.removeAll();
					graph.add(new XChartPanel(stockGraph.drawGraph(stock, time)));
					revalidate();
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
					error.setText("Invalid stock code entered. Please enter a valid stock code.");
					emoji.setIcon(new ImageIcon());
					revalidate();
				}
			}
		});
		
		daily.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Daily clicked!");
				time = "1d";
			}
		});
		
		monthly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Monthly clicked!");
				time = "1m";
			}
		});
		
		quarterly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Quarterly clicked!");
				time = "3m";
			}
		});
		
		yearly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Yearly clicked!");
				time = "ytd";
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StockMasterGUI stockMasterGUI = new StockMasterGUI();
			}
		});
	}
}