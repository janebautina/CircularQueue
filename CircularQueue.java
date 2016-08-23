package CircularQueue;

import java.util.NoSuchElementException;

/**
 * Circular Queue realization
 * 
 * @param <Element>
 *            Circular Queue element's data type
 */
public class CircularQueue<Element> {

	private Element[] queueArray;
	private int front;
	private int rear;
	private int capacity;
	public int numberOfElements;
	
	/**
	 * Constructor
	 * @param size - the circular queue array size
	 */
	public CircularQueue(int size) {
		this.capacity = size;
		this.front = -1;
		this.rear = -1;
		this.queueArray = (Element[]) new Object[this.capacity];
		this.numberOfElements = 0;
	}
	
	/**
	 * Get last element's index 
	 * @return first element's index in 
	 * the circular queue's array
	 */
	public int getFront() {
		return this.front;
	}

	/**
	 * Get last element's index 
	 * @return last element's index 
	 * in the circular queue's array
	 */
	public int getRear() {
		return this.rear;
	}

	/**
	 * Get number of elements in the circular queue
	 * @return number of elements in the circular queue
	 */
	public int getNumberOfElements() {
		return this.numberOfElements;
	}
    
	public Element[] getQueueArray() {
		return this.queueArray;
	}

	/**
	 * Check that queue is empty
	 * @return true if there aren't 
	 * elements in the circular queue
	 */
	public boolean isEmpty() {
		return this.numberOfElements == 0;
	}
    
	/**
	 * Check that the circular queue is full
	 * @return true if the circular queue is full
	 */
	public boolean isFull() {
		return this.numberOfElements == this.capacity;
	}

	/**
	 * Add an element to the circular queue
	 * @param element - element to be added to the circular queue
	 * @throws NoSuchElementException
	 */
	public void enqueue(Element element) throws NoSuchElementException {
		if (isFull())
			throw new IllegalStateException("Queue is full");
		if (element == null)
			throw new NullPointerException("Element is null");
		else {
			if (isEmpty()) {
				front = rear = 0;
			}
			if (rear > numberOfElements) { // return to the beginning
				rear = 0;
			}
			queueArray[rear] = element;
			rear++;
			this.numberOfElements++;
		}
	}
	
	/**
	 * Get an element from the circular queue
	 * @return element from the circular queue
	 */
	public Element dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Empty queue.");
		Element result = queueArray[front];
		queueArray[front] = null;
		front++;
		this.numberOfElements--;
		return result;
	}
}
