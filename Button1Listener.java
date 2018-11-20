import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Button1Listener implements ActionListener {

	private JLabel label;
	private JTextField textField;
	private String stockCode;
	
	public Button1Listener(JLabel label, JTextField textField) {
		this.label = label;
		this.textField = textField;
		this.stockCode = textField.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("I've been clicked!");
		
	}
	
	public String getStockCode() {
		return stockCode;
	}
}