package main;

import java.io.IOException;
import java.util.TreeMap;

import org.json.JSONException;

public class TestGraph {
	public static void main(String[] args) {
//		StockData sd = new StockData();
//		try {
//			TreeMap<String, Double> tm= sd.getStockPrice("aapl", "1d");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DataPlot dp = new DataPlot();
		try {
			dp.drawTimeGraph("aapl", "1d");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
