package test;


import static org.junit.Assert.assertNotNull;
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
	
	//Test purpose: tests basic functionality and check if API response is returned for different date range and stock ticker
	@Test
	public void testAPIResponse1() throws IOException, JSONException {
		stockData = new StockData();
		assertNotNull(stockData.getStockPrice("aapl", "ytd"));
	}
	
	//Test purpose: tests basic functionality and check if API response is returned for different date range and stock ticker
	@Test
	public void testAPIResponse2() throws IOException, JSONException {
		stockData = new StockData();
		assertNotNull(stockData.getStockPrice("tsla", "1m"));
	}
	
	//Test purpose: tests basic functionality and check if API response is returned for different date range and stock ticker
	@Test
	public void testAPIResponse3() throws IOException, JSONException {
		stockData = new StockData();
		assertNotNull(stockData.getStockPrice("csco", "3m"));
	}
	
	//Test purpose: tests basic functionality and check if API response is returned for different date range and stock ticker
	@Test
	public void testAPIResponse4() throws IOException, JSONException {
		stockData = new StockData();
		assertNotNull(stockData.getStockPrice("qqq", "1d"));
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