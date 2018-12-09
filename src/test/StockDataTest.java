package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.TreeMap;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.StockData;

/**
 *
 * This is an test class for StockData class methods.
 *
 */
public class StockDataTest {

	StockData stockData;
	
	@BeforeEach
	public void setUp() {
		stockData = new StockData();
	}
	
	//Test purpose: tests basic functionality and check if the first data point is accurate
	@Test
	public void testDataAccuracy1() throws IOException, JSONException {
		stockData = new StockData();
		Double data = 167.6431;
		assertEquals(data, stockData.getStockPrice("aapl", "ytd").get("2018-01-02"));
	}
	
	//Test purpose: tests basic functionality and check if the first data point is accurate
	@Test
	public void testDataAccuracy2() throws IOException, JSONException {
		stockData = new StockData();
		Double data = 173.39;
		assertEquals(data, stockData.getStockPrice("aapl", "1d").get("09:30"));
	}
	
	//Test purpose: tests basic functionality and check if the first data point is accurate
	@Test
	public void testDataAccuracy3() throws IOException, JSONException {
		stockData = new StockData();
		Double data = 218.4279;
		assertEquals(data, stockData.getStockPrice("aapl", "1m").get("2018-10-29"));
	}
	
	//Test purpose: tests basic functionality and check if the first data point is accurate
	@Test
	public void testDataAccuracy4() throws IOException, JSONException {
		stockData = new StockData();
		Double data = 218.2485;
		assertEquals(data, stockData.getStockPrice("aapl", "3m").get("2018-08-28"));
	}
  
	//Test purpose: test IOException is thrown with getStockPrice method when stock ticker is invalid
    @Test
	public void testIOException1() {
    	stockData = new StockData();
	    Assertions.assertThrows(IOException.class, () -> {
	    	stockData.getStockPrice("", "");
	    });
	}
    
   //Test purpose: test IOException is thrown with getStockPrice method when stock ticker is invalid
    @Test
	public void testIOException2() {
    	stockData = new StockData();
	    Assertions.assertThrows(IOException.class, () -> {
	    	stockData.getStockPrice("1234", "1m");
	    });
	}
    
    //Test purpose: test JSONException is thrown with parseJSON method when JSON response is invalid
    @Test
	public void testJSONException1() {
    	stockData = new StockData();
	    Assertions.assertThrows(JSONException.class, () -> {
	    	TreeMap<String, Double> tm = new TreeMap<>();
	    	stockData.parseJSON(tm, "", "1m");
	    });
	}
    
    //Test purpose: test JSONException is thrown with parseJSON method when JSON response is invalid
    @Test
	public void testJSONException2() {
    	stockData = new StockData();
	    Assertions.assertThrows(JSONException.class, () -> {
	    	TreeMap<String, Double> tm = new TreeMap<>();
	    	stockData.parseJSON(tm, "{stock:1}", "1m");
	    });
	}
}