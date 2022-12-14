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
		 * @param previous
		 * @param next
		 * @param value
		 */
		
		private ListNode(ListNode previous, ListNode next, Object value) {
			this.previous = previous;
			this.next = next;
			this.value = value;
		}
		
		/**
		 * Node of a linked list.
		 * @param value Value of the node.
		 */
		
		private ListNode(Object value) {
			this(null, null, value);
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
    public int size() {
        return this.size;
    }
	
	/**
	 * Gets the node on the given index of the list. Auxilary method.
	 * @param index Index of the wanted element
	 * @return Returns the reference to the object on the given index of the list.
	 */
	
	private ListNode getNode(int index) {
		if(index < 0 || index > this.size - 1) throw new IndexOutOfBoundsException("Index out of bounds!");
		
		ListNode curr;
		if (index < (this.size() - 1) / 2) {
			curr = this.first;
	        for (int i = 0; i < index; i++)
	        	curr = curr.next;
	        
	    } else {
	        curr = this.last;
	        for (int i = this.size() - 1; i > index; i--) 
	        	curr = curr.previous;
	        }

	    return curr;
	}
	
	/**
	 * Gets the Object on the given index of the list.
	 * @param index Index of the wanted element
	 * @return Returns the reference to the object on the given index of the list.
	 */
   
    public Object get(int index) {
    	if(index < 0 || index > this.size() - 1) throw new IndexOutOfBoundsException("Index out of bounds!");
		return getNode(index).value;
    }
    
    @Override
    public boolean contains(Object value) {
    	ListNode curr = this.first;
        for(int i = 0; i < this.size(); i++) {
        	if(curr.value == value)
        		return true;
        	curr = curr.next;
        }
        return false;
    }
    
	/**
	 * Inserts the {@code value} in to the collection.
	 * @param value Value that is to be inserted.
	 * @param position Position on which the value will be inserted.
	 * 
	 */


    public void insert(Object value, int position) {
        if (value == null) throw new NullPointerException("The passed value cannot be null!");
        if(position < 0 || position > this.size()) throw new IllegalArgumentException("Position must be between 0 and size");

		ListNode newNode = new ListNode(value);
		
		if(this.first == null) {
			this.first = newNode;
			this.last = newNode;
			this.size++;
			return;
		}
		
		if(position == 0) {
			newNode.next = this.first;
			this.first.previous = newNode;
			this.first = newNode;
			this.size++;
			return;
		}
		
		if(position == this.size()) {
			newNode.previous = this.last;
			this.last.next = newNode;
			this.last = newNode;
			this.size++;
			return;
		}
		
		ListNode curr = this.getNode(position);
		newNode.previous = curr.previous;
		curr.previous.next = newNode;
		newNode.next = curr;
		curr.previous = newNode;
		this.size++;
		
    }

    @Override
    public void add(Object value) {
        if (value == null) throw new NullPointerException("The passed value cannot be null!");

        this.insert(value, this.size());
    }
    
    @Override
    public void clear() {
		this.first = this.last = null;
		this.size = 0;
	}

    /**
	 * Searches the collection for the first occurence of the given value.
	 * 
	 * @param value Value who's index is being requested.
	 * @return Returns the index of the first occurence of given value in the collection.
	 */
	
	public int indexOf(Object value) {
		
		ListNode current = this.first;
		
		for(int i = 0; i < this.size; i++) {
			if(current.value.equals(value))
				return i;
			current = current.next;
		}
		
		return -1;
	}

	/**
	 * Removes the element of the collection on the given index.
	 * @param index Index of the element that is to be removed.
	 */
	
	public void remove(int index) {
		if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Index out of bounds!");
		
		ListNode del = getNode(index);
		
		if(this.first == null || del == null)
			return;
		
		if(del == this.first)
			this.first = del.next;
		
		if(del.next != null)
			del.next.previous = del.previous;
		
		if(del.previous != null) {
			del.previous.next = del.next;
		}
		
		del.value = null;
		del.previous = null;
		del.next = null;
			
        this.size--;
    }

    @Override
    public boolean remove(Object value) {
        if(!this.contains(value))
        	return false;
        this.remove(this.indexOf(value));
        return true;
    }
 
    @Override
	public Object[] toArray() {
		Object[] arr = new Object[this.size];
		ListNode curr = this.first;
		for(int i = 0; i < this.size; i++) {
			arr[i] = curr.value;
			curr = curr.next;
		}
		return arr;
	}

    @Override
    public void forEach(Processor processor) {
        ListNode curr = this.first;
        for(int i = 0; i < this.size(); i++){
            processor.process(curr.value);
            curr = curr.next;
        }
    }

}