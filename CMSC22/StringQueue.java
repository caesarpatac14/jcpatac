import java.util.*;

public class StringQueue {
	private String[] elements;
	private int count;
	private int plus = 0;
	public static final int DEFAULT_SIZE = 10;

	public StringQueue() {
		elements = new String[DEFAULT_SIZE];
	}

	public int size() {
		return count;
	}

	public void enqueue(String item) {
		if (count >= elements.length) {
			elements = Arrays.copyOf(elements, elements.length + DEFAULT_SIZE);
		}
		elements[count] = item;
		count++;
	}

	public String dequeue() {
		int index = count - count;
		String result = "";
		if (count <= 0) {
			throw new IllegalArgumentException("Queue is empty!");
		}
		result = elements[index + plus];
		count--;
		plus++;
		return result;

	}

	public String peek() {
		if (count <= 0) {
			throw new IllegalArgumentException("Queue is empty!");
		}
		return elements[0];
	}

	public String toString(){
		if (count <= 0) {
			throw new IllegalArgumentException("EMPTY!");
		}
		String result = "";
		for (int i = 0; i < count - 1; i++) {
			result += elements[i] + ", ";
		}
		return result + elements[count - 1];

	}

	public static void main(String[] args) {
		StringQueue queue = new StringQueue();
		queue.enqueue("stack");
		queue.enqueue("overflow");
		queue.enqueue("com");
		System.out.println("QUEUE: " + queue);
		System.out.println("SIZE:" + queue.size());

		String peek1 = queue.peek();
		System.out.println("PEEK: " + peek1);

		String item1 = queue.dequeue();
		String item2 = queue.dequeue();
		System.out.println("DEQUEUE 1: " + item1);
		System.out.println("DEQUEUE 2: " + item2);
		System.out.println("QUEUE: " + queue);
		System.out.println("SIZE:" + queue.size());

	}
}

