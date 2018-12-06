package main;

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

/**
 * 
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
	private JLabel error;
	private JLabel emoji;
	protected String stock = "aapl";
	protected String time = "1y";
	private double sentiment = 0;

	public StockMasterGUI() {
		createFrame();
		addListeners();
	}
	
	private void createFrame() {
		setTitle("StockMaster");
		setSize(400, 600);
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
		
		panel.add(askStock);
		panel.add(textField);
		panel.add(search);
		panel.add(daily);
		panel.add(monthly);
		panel.add(quarterly);
		panel.add(yearly);
		panel.add(error);
		panel.add(emoji);
		add(panel);
		setVisible(true);
	}
	
	private void addListeners() {
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Search clicked!");
				SentimentAnalysis stockNews = new SentimentAnalysis(textField.getText());
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
					revalidate();
				} catch (IOException e1) {
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
				time = "1y";
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