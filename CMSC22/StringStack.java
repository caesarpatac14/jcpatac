import java.util.*;

public class StringStack {
	private String[] elements;
	private int count;
	public static final int DEFAULT_SIZE = 10;

	public void push(String item) {
		if (count >= elements.length) {
			elements = Arrays.copyOf(elements, elements.length + DEFAULT_SIZE);
		}
		elements[count] = item;
		count++; 
	}

	public String pop() {
		if (count <= 0) {
			throw new IllegalArgumentException("Stack is empty!");
		}
		count--;
		return elements[count];
	}

	public String peek() {
		return elements[count - 1];
	}

	public int size() {
		return count;
	}

	public StringStack(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Invalid size!");
		}
		elements = new String[size];
	}

	public StringStack() {
		this(DEFAULT_SIZE);
	}

	public String toString() {
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
		StringStack stack = new StringStack(20);
		stack.push("stack");
		stack.push("overflow");
		stack.push("com");
		System.out.println("STACK: " + stack);
		System.out.println("SIZE: " + stack.size());

		String peek1 = stack.peek();
		System.out.println("PEEK: " + peek1);

		String item1 = stack.pop();
		String item2 = stack.pop();
		System.out.println("POP 1: " + item1);
		System.out.println("POP 2: " + item2);
		System.out.println("STACK: " + stack);
		System.out.println("SIZE: " + stack.size());
	}
}