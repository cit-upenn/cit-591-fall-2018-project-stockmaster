import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StockMaster {

	private static final long serialVersionUID = 1L;
	URL url;
	BufferedImage img;
	JLabel enterStockLabel;
	JTextField stockTextField;
	JButton submitButton;
	ImageIcon icon;
	JLabel enterLabel;
	JPanel panel;
	
	public StockMaster() {
		createSubmitButton();
		createComponents();		
	}
	
	private void getStock(String city) {
		try {	
			city=URLEncoder.encode(city, "UTF-8");
			String queryParams = "center="+city+"&zoom=12&size=400x400&key="+UnpluggAPISecretFile.key;
			String mapsURL = UnpluggAPISecretFile.endPoint + UnpluggAPISecretFile.staticMapsPath + queryParams;		
			mapsURL=URLEncoder.encode(mapsURL, "UTF-8");
			System.out.println(mapsURL);
			url = new URL(mapsURL);					
			img = ImageIO.read(url);
			icon = new ImageIcon(img);
			enterLabel.setIcon(icon);// = new JLabel(icon);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void createSubmitButton() {
		submitButton = new JButton("Search");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String stock = stockTextField.getText();
				getStock(stock);				
			}
		});
	}
	
	private void createComponents() {
		enterStockLabel = new JLabel("Enter a stock");
		stockTextField = new JTextField(15);
		enterLabel = new JLabel();
		panel = new JPanel();
		panel.add(enterStockLabel);
		panel.add(stockTextField);
		panel.add(submitButton);
		getStock("GOOGL");
		panel.add(enterLabel);
		add(panel);
		setSize(1000,800);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	    	  StockMaster frame = new StockMaster();
	      }
	    });		
	}
	
}