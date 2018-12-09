package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.NewsAnalysis;

/**
 *
 * This is an test class for StockData class methods.
 * 
 */
public class NewsAnalysisTest {

	NewsAnalysis newsAnalysis;
	
	//Test purpose: tests basic functionality
	@Test
	public void testSentimentAnalysis() throws IOException, JSONException {
		newsAnalysis = new NewsAnalysis("aapl");
		assertNotNull(newsAnalysis.getNewsSummary());
		assertNotNull(newsAnalysis.getSentiment());
	}
	
  
	//Test purpose: test IOException is thrown with getNewsSummary method when stock ticker is invalid
    @Test
	public void testIOException1() {
    	newsAnalysis = new NewsAnalysis("");
	    Assertions.assertThrows(IOException.class, () -> {
	    	newsAnalysis.getNewsSummary();
	    });
	}
    
    //Test purpose: test IOException is thrown with getNewsSummary method when stock ticker is invalid
    @Test
	public void testIOException2() {
    	newsAnalysis = new NewsAnalysis("symbol");
	    Assertions.assertThrows(IOException.class, () -> {
	    	newsAnalysis.getNewsSummary();
	    });
	}
    
    //Test purpose: test JSONException is thrown with parseJSON method when JSON response is invalid
    @Test
	public void testJSONException1() {
    	newsAnalysis = new NewsAnalysis("aapl");
	    Assertions.assertThrows(JSONException.class, () -> {
	    	String text = "";
	    	newsAnalysis.parseJSON(text, "");
	    });
	}
    
    //Test purpose: test JSONException is thrown with parseJSON method when JSON response is invalid
    @Test
	public void testJSONException2() {
    	newsAnalysis = new NewsAnalysis("goog");
	    Assertions.assertThrows(JSONException.class, () -> {
	    	String text = "";
	    	newsAnalysis.parseJSON(text, "{stock:goog}");
	    });
	}
}