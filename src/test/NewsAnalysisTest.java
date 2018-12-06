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
	
	//Test purpose: tests basic functionality
	@Test
	public void testReplaceAllDigits1() {
		newsAnalysis = new NewsAnalysis("aapl");
		//newsAnalysis.setMyString("Dog456Dog");
		//newsAnalysis.replaceAllDigits('X');
		//assertEquals("DogXXXDog", newsAnalysis.getMyString());
	}
  
	//Test purpose: test CollectionUnderflowException is thrown with get method
    @Test
	public void testIOException() {
    	newsAnalysis = new NewsAnalysis("aapl");
	    Assertions.assertThrows(IOException.class, () -> {
	    	//newsAnalysis.add("Hello");
	    	//newsAnalysis.add(5);
	    	//newsAnalysis.get(3);
	    });
	}
}