package hr.fer.oprpp1.custom.collections;

/**
 * Class Collection represents some general collection of objects
 * @author MatijaPavlovic
 *
 */

public class Collection {
	
	/**
	 * Default protected constructor
	 */
	
	protected Collection() {
		
	}
	
	/**
	 * 
	 * @return Returns {@code true} if collection contains no objects and {@code false} otherwise
	 */
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	/**
	 * 
	 * @return Returns the number of currently stored objects in this collections.
	 */
	
	public int size() {
		return 0;
	}
	
	/**
	 * Adds the given object into this collection.
	 */
	
	public void add(Object value) {
		
	}
	
	/**
	 * @return Returns {@code true} only if the collection contains given value, otherwise returns {@code false}
	 */
	
	public boolean contains(Object value) {
		return false;
	}
	
	/**
	 * @return Returns {@code true} only if the collection contains given value as determined by equals method and removes
	 * one occurrence of it
	 */
	
	public boolean remove(Object value) {
		return false;
	}
	
	/**
	 * @return Allocates new array with size equals to the size of this collections, fills it with collection content and
	 * returns the array.
	 */
	
	public Object[] toArray() {
		throw new UnsupportedOperationException("This operation can not be executed!");
	}
	
	/**
	 * Method calls processor.process(.) for each element of this collection. The order in which elements
	 * will be sent is undefined in this class.
	 * @param instance of a class {@code Processor} that processes all elements of the collection.
	 */
	
	public void forEach(Processor processor) {
		
	}
	
	/**
	 * 
	 * @param other is an instance of a {@code Collection} whose elements will be added to given collection.
	 */
	
	public void addAll(Collection other) {
		
		/**
		 * Local class that extends the Processor class. Overrides the method {@code process} and then uses it as an
		 * argument in the {@code forEach} method.
		 * @author MatijaPav
		 *
		 */
		
		class addEachItemProcessor extends Processor {
			@Override
			public void process(Object value) {
				add(value);
			}
		}
		
		Processor processor = new addEachItemProcessor();
		other.forEach(processor);
		
	}
	
	/**
	 * Removes all elements from this collection.
	 */
	
	public void clear() {
		
	}
	
}