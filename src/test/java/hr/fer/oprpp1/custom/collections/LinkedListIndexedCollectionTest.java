package hr.fer.oprpp1.custom.collections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListIndexedCollectionTest {
	
	private LinkedListIndexedCollection singleElementList;
	private LinkedListIndexedCollection emptyList;
	private LinkedListIndexedCollection multipleElementsList;
	private LinkedListIndexedCollection addedList;
	

	void setUp() {
		emptyList = new LinkedListIndexedCollection();
		
		singleElementList = new LinkedListIndexedCollection();
		singleElementList.add(1);
		
		multipleElementsList = new LinkedListIndexedCollection();
		
		for(int i = 0; i < 3; i++) {
			multipleElementsList.add(i);
		}
		
		addedList = new LinkedListIndexedCollection(multipleElementsList);
	}

	
	@Test
	@DisplayName("Ensure that null values can't be added to a list.")
	
	public void testAddingNullValues() {
		setUp();
		assertThrows(NullPointerException.class, () -> emptyList.add(null));
	}
	
	@Test
	@DisplayName("Ensure that get(int index) works.")
	
	public void testGet() {
		setUp();
		assertEquals(0, multipleElementsList.get(0));
		assertEquals(2, addedList.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> multipleElementsList.get(10));
	}
	
	@Test
	@DisplayName("Ensure size() works correctly.")
	
	public void testSize() {
		setUp();
		assertEquals(0, emptyList.size());
		assertEquals(1, singleElementList.size());
		assertEquals(3, multipleElementsList.size());
		addedList.add(5);
		assertEquals(4, addedList.size());
	}
	
	@Test
	@DisplayName("Ensure clear() works correctly.")
	
	public void testClear() {
		setUp();
		multipleElementsList.clear();
		assertEquals(0, multipleElementsList.size());
	}
	
	@Test
	@DisplayName("Ensure that contains works correctly.")
	
	public void testContains() {
		setUp();
		assertEquals(true, multipleElementsList.contains(1));
		assertEquals(false, emptyList.contains(1));
		assertEquals(false, multipleElementsList.contains(5));
	}
	
	@Test
	@DisplayName("Ensure that remove works correctly.")
	
	public void testRemove() {
		setUp();
		multipleElementsList.remove(0);
		assertArrayEquals(new Object[] {1, 2}, multipleElementsList.toArray());
	}
	
	@Test
	@DisplayName("Ensure that toArray() works correctly.")
	
	public void testToArray() {
		setUp();
		assertArrayEquals(new Object[] {0, 1, 2}, multipleElementsList.toArray());
		assertArrayEquals(new Object[] {1}, singleElementList.toArray());
		assertArrayEquals(new Object[] {}, emptyList.toArray());
	}
	
	@Test
	@DisplayName("Ensure that addAll() works correctly.")
	
	public void testAddAll() {
		setUp();
		assertArrayEquals(multipleElementsList.toArray(), addedList.toArray());
	}
	
	@Test
	@DisplayName("Ensure that insert() works correctly.")
	
	public void testInsert() {
		setUp();
		multipleElementsList.insert(3, 2);
		assertArrayEquals(new Object[] {0, 1, 3, 2}, multipleElementsList.toArray());
	}
	
}
