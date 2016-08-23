package CircularQueue;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestCircularQueue extends TestCase {
	private CircularQueue<Integer> queueInt;

	public TestCircularQueue(String testName) {
		super(testName);
		queueInt = new CircularQueue<Integer>(5);
	}

	public void testIsFull() {
		queueInt.enqueue(1);
		queueInt.enqueue(2);
		queueInt.enqueue(3);
		queueInt.enqueue(4);
		queueInt.enqueue(5);
		assertTrue("Queue is full!", queueInt.isFull());
		queueInt.dequeue();
		queueInt.enqueue(0);
		assertTrue("Queue is full!", queueInt.isFull());
	}

	public void testIsEmpty() {
		assertTrue("Queue is empty!", queueInt.isEmpty());
		queueInt.enqueue(1);
		queueInt.dequeue();
		assertTrue("Queue is empty!", queueInt.isEmpty());
	}

	public void testEnque() {
		queueInt.enqueue(1);
		queueInt.enqueue(2);
		Integer[] expected = new Integer[5];
		expected[0] = 1;
		expected[1] = 2;
		assertTrue(Arrays.equals(expected, queueInt.getQueueArray()));
		queueInt.enqueue(3);
		queueInt.enqueue(4);
		queueInt.enqueue(5);
		expected[2] = 3;
		expected[3] = 4;
		expected[4] = 5;
		queueInt.dequeue();
		queueInt.enqueue(6);
		expected[0] = 6;
		assertTrue(Arrays.equals(expected, queueInt.getQueueArray()));
	}
	
	public void testDeQueue() {
		queueInt.enqueue(1);
		assertEquals(queueInt.getFront(), 0);
		assertEquals(queueInt.getRear(), 1);
		assertEquals(queueInt.getNumberOfElements(), 1);
		assertEquals(queueInt.dequeue(), new Integer(1));
		assertEquals(queueInt.getFront(), 1);
		assertEquals(queueInt.getRear(), 1);
		assertEquals(queueInt.getNumberOfElements(), 0);
		assertTrue(queueInt.isEmpty());
		queueInt.enqueue(2);
		assertEquals(queueInt.getFront(), 0);
		assertEquals(queueInt.getRear(), 1);
		assertEquals(queueInt.getNumberOfElements(), 1);
		queueInt.enqueue(3);
		assertEquals(queueInt.getFront(), 0);
		assertEquals(queueInt.getRear(), 2);
		assertEquals(queueInt.getNumberOfElements(), 2);
		queueInt.enqueue(4);
		assertEquals(queueInt.getFront(), 0);
		assertEquals(queueInt.getRear(), 3);
		assertEquals(queueInt.getNumberOfElements(), 3);
		queueInt.enqueue(5);
		assertEquals(queueInt.getFront(), 0);
		assertEquals(queueInt.getRear(), 4);
		assertEquals(queueInt.getNumberOfElements(), 4);
		queueInt.enqueue(6);
		assertEquals(queueInt.getFront(), 0);
		assertEquals(queueInt.getRear(), 5);
		assertEquals(queueInt.getNumberOfElements(), 5);
		assertTrue(queueInt.isFull());
		assertEquals(queueInt.dequeue(), new Integer(2));
		assertEquals(queueInt.getFront(), 1);
		assertEquals(queueInt.getRear(), 5);
		queueInt.enqueue(1);
		assertEquals(queueInt.getFront(), 1);
		assertEquals(queueInt.getRear(), 1);
		assertEquals(queueInt.dequeue(), new Integer(3));
		assertEquals(queueInt.getFront(), 2);
		assertEquals(queueInt.getRear(), 1);
		queueInt.enqueue(2);
		assertTrue(queueInt.isFull());
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CircularQueue.TestCircularQueue");
	}
}
