package hr.fer.oprpp1.custom.collections;

/**
 * Implementation of Linked list
 * @author MatijaPav
 *
 */

public class LinkedListIndexedCollection extends Collection {
	
	private static class ListNode {
		
		/**
		 * Reference to previous node.
		 */
		
		private ListNode previous;
		
		/**
		 * Reference to next node.
		 */
		
		private ListNode next;
		
		/**
		 * Reference to the value stored in the node.
		 */
		
		private Object value;
		
		/**
		 * Node of a linked list.
		 * @param value Value of the node.
		 */
		
		private ListNode(Object value) {
			this(null, null, value);
		}
		
		/**
		 * Node of a linked list.
		 * @param previous
		 * @param next
		 * @param value
		 */
		
		private ListNode(ListNode previous, ListNode next, Object value) {
			this.previous = previous;
			this.next = next;
			this.value = value;
		}
		
		
		
	}
	
	/**
	 * Number of elements contained iz the collection.
	 */
	
	private int size;
	
	/**
	 * Reference to the first node of the list.
	 */
	
	private ListNode first;
	
	/**
	 * Reference to the last node of the list.
	 */
	
	private ListNode last;
	
	/**
	 * Default constructor
	 */
	
	public LinkedListIndexedCollection() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	public LinkedListIndexedCollection(LinkedListIndexedCollection other) {
		this.addAll(other);
	}
	
	@Override
	
	public void add(Object value) {
		if(value.equals(null)) throw new NullPointerException("Can not add null to a collection!");
		
		ListNode newNode = new ListNode(value);
		this.size++;
		
		if(this.first.equals(null)) {
			this.first = this.last = newNode;
		} else {
			newNode.previous = this.last;
			this.last.next = newNode;
			this.last = newNode;
		}
	}
	
	/**
	 * Gets the object on the given index of the list.
	 * @param index Index of the wanted element
	 * @return Returns the reference to the object on the given index of the list.
	 */
	
	public Object get(int index) {
		if(index < 0 || index > this.size - 1) throw new IndexOutOfBoundsException("Index out of bounds!");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
