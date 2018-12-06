package test;

import java.io.IOException;

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
	
	//Test purpose: tests basic functionality
	@Test
	public void testReplaceAllDigits1() {
		//dataPlot.setMyString("Dog456Dog");
		//dataPlot.replaceAllDigits('X');
		//assertEquals("DogXXXDog", dataPlot.getMyString());
	}
  
	//Test purpose: test CollectionUnderflowException is thrown with get method
    @Test
	public void testIOException() {
	    Assertions.assertThrows(IOException.class, () -> {
	    	//dataPlot.add("Hello");
	    	//dataPlot.add(5);
	    	//dataPlot.get(3);
	    });
	}
}