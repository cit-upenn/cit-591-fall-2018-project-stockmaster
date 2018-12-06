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
	 * 
	 * @param stock
	 * @param time
	 * @return
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
        JSONArray ja = new JSONArray(jsonText);
        TreeMap<String, Double> tm = new TreeMap<String, Double>();
        switch (time) {
        case "ytd":
        	for (int i = 0; i < ja.length(); i += 12) {
        		JSONObject object = ja.getJSONObject(i);
        		String date = object.getString("date");
        		double open = object.getDouble("open");
        		tm.put(date, open);
            }
        	break;
        case "1d":
        	for (int i = 0; i < ja.length(); i += 24) {
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
        return tm;
    }
}