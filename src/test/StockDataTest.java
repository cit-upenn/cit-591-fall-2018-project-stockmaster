package test;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.StockData;

/**
 *
 * This is an test class for a simple class that represents a Collection of Objects.
 *
 * You should create a behavior test that tests for a CollectionUnderflowException when
 * attempting to remove more objects than is in the Collection.
 */
public class StockDataTest {

	StockData stockData;
	
	@BeforeEach
	public void setUp() {
		stockData = new StockData();
	}
	
	//Test purpose: tests basic functionality
	@Test
	public void testReplaceAllDigits1() {
		stockData = new StockData();
		//stockData.setMyString("Dog456Dog");
		//stockData.replaceAllDigits('X');
		//assertEquals("DogXXXDog", stockData.getMyString());
	}
  
	//Test purpose: test CollectionUnderflowException is thrown with get method
    @Test
	public void testIOException() {
    	stockData = new StockData();
	    Assertions.assertThrows(IOException.class, () -> {
	    	//stockData.add("Hello");
	    	//stockData.add(5);
	    	//stockData.get(3);
	    });
	}
}