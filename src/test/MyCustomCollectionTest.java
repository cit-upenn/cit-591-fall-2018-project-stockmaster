package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.CollectionUnderflowException;
import main.MyCustomCollection;
import main.MyCustomCollectionInterface;

/**
 *
 * This is an test class for a simple class that represents a Collection of Objects.
 *
 * You should create a behavior test that tests for a CollectionUnderflowException when
 * attempting to remove more objects than is in the Collection.
 */

public class MyCustomCollectionTest {

	MyCustomCollectionInterface myCustomCollection;

	//Test Purpose: Test get method works as expected
	@Test
	public void exceptionTest() {
		myCustomCollection = new MyCustomCollection();
  		myCustomCollection.add("Hello");
  		assertEquals("Hello", myCustomCollection.get(0));
  	}
  
	//Test Purpose: Test CollectionUnderflowException is thrown with get method
    @Test
	public void testGetThrowsExpectedException() {
    	myCustomCollection = new MyCustomCollection();
	    Assertions.assertThrows(CollectionUnderflowException.class, () -> {
	    	myCustomCollection.add("Hello");
	        myCustomCollection.add(5);
	        myCustomCollection.get(3);
	    });
	}
    
    //Test Purpose: Test CollectionUnderflowException is thrown with get method
    @Test
	public void testRemoveThrowsExpectedException() {
    	//your code here
    	myCustomCollection = new MyCustomCollection();
    	Assertions.assertThrows(CollectionUnderflowException.class, () -> {
	    	myCustomCollection.add("Hello");
	    	myCustomCollection.add(5);
	        myCustomCollection.remove(3);
	    });
    }
}