package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.DataPlot;

/**
 *
 * This is an test class for a simple class that represents a Collection of Objects.
 *
 * You should create a behavior test that tests for a CollectionUnderflowException when
 * attempting to remove more objects than is in the Collection.
 */
public class DataPlotTest {

	DataPlot dataPlot;
	
	@BeforeEach
	public void setUp() {
		dataPlot = new DataPlot();
	}
	
	//Test Purpose: check if the long term plot could be generated successfully
	@Test
	public void LongtermTest() throws IOException, JSONException, ParseException {
		DataPlot dp2 = new DataPlot();
		assertNotNull(dp2.getLongTermChart("aapl", "ytd"));		
	}
	
	//Test Purpose: check if the short term plot could be generated successfully
	@Test
	public void ShorttermTest() throws IOException, JSONException, ParseException {
		DataPlot dp2 = new DataPlot();
		assertNotNull(dp2.getShortTermChart("aapl", "1d"));		
	}
  
	//Test purpose: test IOException is thrown when stock code or time is not available
    @Test
	public void testIOException() {
	    Assertions.assertThrows(IOException.class, () -> {
	    	DataPlot dp = new DataPlot();
			dp.getLongTermChart("xxxx", " ");
			fail("No exception throwed.");
	    });
	}
}