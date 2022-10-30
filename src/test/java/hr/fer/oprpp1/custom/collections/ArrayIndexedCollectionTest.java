package hr.fer.oprpp1.custom.collections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayIndexedCollectionTest {
	
	private ArrayIndexedCollection emptyCollection;
	private ArrayIndexedCollection singleElementCollection;
	private ArrayIndexedCollection multipleElementCollection;
	private ArrayIndexedCollection fullCollection;

	void setUp() {
		emptyCollection = new ArrayIndexedCollection();
		singleElementCollection = new ArrayIndexedCollection();
		multipleElementCollection = new ArrayIndexedCollection();
		fullCollection = new ArrayIndexedCollection(5);
		
		singleElementCollection.add(1);
		
		for(int i = 0; i < 3; i++) {
			multipleElementCollection.add(i);
		}
		
		for(int i = 0; i < 5; i++) {
			fullCollection.add(i);
		}
		
	}
	
	@Test
	@DisplayName("Test addAll")
	
	public void testAddAll() {
		setUp();
		ArrayIndexedCollection coll = new ArrayIndexedCollection(multipleElementCollection);
		assertEquals(coll.get(0), multipleElementCollection.get(0));
	}
	
	@Test
	@DisplayName("Ensure that null can't be passed as other collection.")
	
	public void testPassNullAsOtherCollection() {
		setUp();
		assertThrows(NullPointerException.class, () -> new ArrayIndexedCollection(null));
	}
	
	@Test
	@DisplayName("Ensure that initial capacity is at least 1.")
	
	public void testSetInitialCapacityToLessThanOne() {
		setUp();
		assertThrows(IllegalArgumentException.class, () -> new ArrayIndexedCollection(0));
	}
	
	@Test
	@DisplayName("Ensure that null values can't be added.")
	
	public void testAddNullValueToCollection() {
		setUp();
		assertThrows(NullPointerException.class, () -> emptyCollection.add(null));
	}
	
	@Test
	@DisplayName("Ensure that size() works correctly.")
	
	public void testSize() {
		setUp();
		assertEquals(0, emptyCollection.size());
	}
	
	@Test
	@DisplayName("Ensure that size() works correctly.")
	
	public void testSize2() {
		setUp();
		assertEquals(1, new ArrayIndexedCollection(singleElementCollection).size());
	}
	
	@Test
	@DisplayName("Ensure that size() works correctly when element is added.")
	
	public void testSize3() {
		setUp();
		singleElementCollection.add(2);
		assertEquals(2, singleElementCollection.size());
	}
	
	@Test
	@DisplayName("Ensure that size() works correctly when element is removed.")
	
	public void testSize4() {
		setUp();
		singleElementCollection.remove(0);
		assertEquals(0, singleElementCollection.size());
	}
	
	@Test
	@DisplayName("Ensure that size() works correctly when collection is cleared.")
	
	public void testSize5() {
		setUp();
		multipleElementCollection.clear();
		assertEquals(0, multipleElementCollection.size());
	}
	
	@Test
	@DisplayName("Ensure that indexOf works.")
	
	public void testIndexOf() {
		setUp();
		assertEquals(1, multipleElementCollection.indexOf(1));
	}
	
	@Test
	@DisplayName("Ensure that indexOf returns -1 when element is not present in the collection.")
	
	public void testIndexOf2() {
		setUp();
		assertEquals(-1, multipleElementCollection.indexOf("X"));
	}
	
	@Test
	@DisplayName("Ensure that toArray() works")
	
	public void testToArray() {
		setUp();
		assertArrayEquals(new Object[] {0, 1, 2}, multipleElementCollection.toArray());
	}
	
	@Test
	@DisplayName("Ensure that contains works.")
	
	public void testContains() {
		setUp();
		assertEquals(true, singleElementCollection.contains(1));
		assertEquals(false, singleElementCollection.contains(2));
	}
	
	@Test
	@DisplayName("Ensure that remove works.")
	
	public void testRemove() {
		setUp();
		assertThrows(IndexOutOfBoundsException.class, () -> multipleElementCollection.remove(5));
		assertThrows(IndexOutOfBoundsException.class, () -> multipleElementCollection.remove(-1));
		singleElementCollection.remove(0);
		assertEquals(0, singleElementCollection.size());
		multipleElementCollection.remove(2);
		assertEquals(false, multipleElementCollection.contains(2));
	}
	
	@Test
	@DisplayName("Ensure that insert works.")
	
	public void testInsert() {
		setUp();
		assertThrows(NullPointerException.class, () -> fullCollection.add(null));
		multipleElementCollection.insert(3, 1);
		assertArrayEquals(new Object[] {0, 3, 1, 2}, multipleElementCollection.toArray());
		assertThrows(IndexOutOfBoundsException.class, () -> singleElementCollection.insert("inserted element", 2));
		singleElementCollection.insert(10, 0);
		assertArrayEquals(new Object[] {10, 1}, singleElementCollection.toArray());
		singleElementCollection.insert(11, 2);
		assertArrayEquals(new Object[] {10, 1, 11}, singleElementCollection.toArray());
	}
	
	@Test
	@DisplayName("Ensure that get works.")
	
	public void testGet() {
		setUp();
		assertThrows(IllegalArgumentException.class, ()-> singleElementCollection.get(2));
		assertEquals(4, fullCollection.get(4));
	}
	
	@Test
	
	public void testAddingMoreThan16elements() {
		setUp();
		for(int i = 0; i < 18; i++) {
			singleElementCollection.add(i);
		}
		assertEquals(19, singleElementCollection.size());
	}
	
	@Test
	
	public void testSizeInAddAll() {
		setUp();
		ArrayIndexedCollection coll = new ArrayIndexedCollection(multipleElementCollection);
		assertEquals(3, coll.size());
	}
	
}