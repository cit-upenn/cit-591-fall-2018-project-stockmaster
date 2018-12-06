package main;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONException;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

public class TestGraph {

	public static void main(String[] args) throws JSONException {
		//JFrame frame = new JFrame();
		//JPanel jpanel = new JPanel();
		DataGraph dg = new DataGraph();
		try {
			dg.drawGraph("aapl", "1y");
			//XChartPanel<XYChart> panel = dg.drawGraph("aapl", "ytd");
			//jpanel.add(panel);
			//frame.add(jpanel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}
}