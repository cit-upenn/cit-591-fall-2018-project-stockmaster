import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeMap;

public class IEXTradingPrices {
	
    public TreeMap<String, Double> getStockPrice(String symbol, String range) throws IOException {
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
        StockDataYearly[] stockDataYTD = null;
        StockDataDaily[] stockData1D = null; 
        StockDataMonthly[] stockData1M = null;
        StockDataMonthly[] stockData3M = null;
        TreeMap<String, Double> tm = new TreeMap<String, Double>();
        
        switch (range) {
        case "ytd":
        	stockDataYTD = gson.fromJson(jsonText, StockDataYearly[].class);
        	for (int i = 0; i < stockDataYTD.length; i++) {
                System.out.println(stockDataYTD[i].getDate());
                System.out.println(stockDataYTD[i].getOpen());
                tm.put(stockDataYTD[i].getDate(), stockDataYTD[i].getOpen());
            }
        	break;
        case "1d":
        	stockData1D = gson.fromJson(jsonText, StockDataDaily[].class);
        	for (int i = 0; i < stockData1D.length; i++) {
                System.out.println(stockData1D[i].getMinute());
                System.out.println(stockData1D[i].getOpen());
                tm.put(stockData1D[i].getMinute(), stockData1D[i].getOpen());
            }
        	break;
        case "1m": 
        	stockData1M = gson.fromJson(jsonText, StockDataMonthly[].class);
        	for (int i = 0; i < stockData1M.length; i++) {
                System.out.println(stockData1M[i].getDate());
                System.out.println(stockData1M[i].getOpen());
                tm.put(stockData1M[i].getDate(), stockData1M[i].getOpen());
            }
        	break;
        case "3m":
        	stockData3M = gson.fromJson(jsonText, StockDataMonthly[].class);
        	for (int i = 0; i < stockData3M.length; i++) {
                System.out.println(stockData3M[i].getDate());
                System.out.println(stockData3M[i].getOpen());
                tm.put(stockData3M[i].getDate(), stockData3M[i].getOpen());
            }
        	break;
        }
        return tm;
    }
}