package main;

import java.io.IOException;

import org.json.JSONException;

public class RunStockMaster {
	public static void main(String[] args) {
		IEXTradingPrices prices = new IEXTradingPrices();
		try {
			System.out.println(prices.getStockPrice("aapl", "ytd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
