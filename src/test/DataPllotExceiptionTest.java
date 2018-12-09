package test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;

import junit.framework.Test;
import main.DataPlot;

public class DataPllotExceiptionTest {
	//Test Purpose: when stock code or time is not available
	@Test (expected = IOException.class)
	public void ValidatedExceptionTest() throws IOException{
		DataPlot dp = new DataPlot();
		dp.getLongTermChart("xxxx", " ");
		fail("No exception throwed.");
	}
	
	//Test Purpose: check if the long term plot could be generated successfully
	@Test 
	public void LongtermTest() throws IOException, JSONException, ParseException {
		DataPlot dp2 = new DataPlot();
		assertNull(dp2.getLongTermChart("aapl", "Yearly"));		
	}
	
	//Test Purpose: check if the short term plot could be generated successfully
	@Test
	public void ShorttermTest() throws IOException, JSONException, ParseException {
		DataPlot dp2 = new DataPlot();
		assertNull(dp2.getShortTermChart("aapl", "Daily"));
		
	}
	

}
