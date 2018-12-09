package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Shiqing (Jill) Liu
 *
 */
public class StockData {
	
	/**
	 * Request IEXTrading API and parse JSON response 
	 * @param stock
	 * @param time
	 * @return a TreeMap that maps date/time to the stock price at the corresponding date/time
	 * @throws IOException
	 * @throws JSONException
	 */
    public TreeMap<String, Double> getStockPrice(String stock, String time) throws IOException, JSONException {
        String jsonText = "";
        URL iex = new URL("https://api.iextrading.com/1.0/stock/" + stock + "/chart/" + time);
        URLConnection iexAPI = iex.openConnection();
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(
        				iexAPI.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        	jsonText += inputLine;
        }
        in.close();
        //System.out.println(jsonText);
        
        TreeMap<String, Double> tm = new TreeMap<String, Double>();
        parseJSON(tm, jsonText, time);
       
        return tm;
    }
    
    /**
     * Parse API response 
     * @param tm A TreeMap that stores date/time and stock price 
     * @param jsonText API response
     * @param time Time range specified by the user 
     * @throws JSONException
     */
    public void parseJSON(TreeMap<String, Double> tm, String jsonText, String time) throws JSONException {
    	 JSONArray ja = new JSONArray(jsonText);
         switch (time) {
         case "ytd":
         	for (int i = 0; i < ja.length(); i += 11) {
         		JSONObject object = ja.getJSONObject(i);
         		String date = object.getString("date");
         		double open = object.getDouble("open");
         		tm.put(date, open);
             }
         	break;
         case "1d":
         	for (int i = 0; i < ja.length(); i += 17) {
         		JSONObject object = ja.getJSONObject(i);
         		String date = object.getString("minute");
         		double open = object.getDouble("open");
         		tm.put(date, open);
             }
         	break;
         case "1m": 
         	for (int i = 0; i < ja.length(); i++) {
         		JSONObject object = ja.getJSONObject(i);
         		String date = object.getString("date");
         		double open = object.getDouble("open");
         		tm.put(date, open);
             }
         	break;
         case "3m":
         	for (int i = 0; i < ja.length(); i += 3) {
         		JSONObject object = ja.getJSONObject(i);
         		String date = object.getString("date");
         		double open = object.getDouble("open");
         		tm.put(date, open);
             }
         	break;
         }
    }
}