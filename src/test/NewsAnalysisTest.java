package test;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.NewsAnalysis;

/**
 *
 * This is an test class for a simple class that represents a Collection of Objects.
 *
 * You should create a behavior test that tests for a CollectionUnderflowException when
 * attempting to remove more objects than is in the Collection.
 */

public class NewsAnalysisTest {

	NewsAnalysis newsAnalysis;
  
	//Test Purpose: Test CollectionUnderflowException is thrown with get method
    @Test
	public void testGetThrowsExpectedException() {
    	newsAnalysis = new NewsAnalysis("aapl");
	    Assertions.assertThrows(IOException.class, () -> {
	    	//stockMasterGUI.
	    });
	}
}