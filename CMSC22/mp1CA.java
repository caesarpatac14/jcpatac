import java.util.Scanner;

public class mp1CA {
	static int[] cells;
	static int[] ruling = {0, 1, 1, 1, 1, 0 ,0 ,0}; // Rule 30 (Reversed for compatibility to function rules)

	public static void main(String[] args) {
		System.out.print("Enter the size: ");
		Scanner scan = new Scanner(System.in);
		System.out.println();
		String arg = scan.next();
		int size = Integer.parseInt(arg);
		cells = new int[size];
		generate();
	}

	// Generate the next generations (Edges wrap around. Donut-like mode)
	public static void generate() {
		for (int i = 0; i < cells.length; i++) {
			cells[i] = 0;
		}
		if (cells.length % 2 != 0) { // Put one seed in first generation if length is odd
			cells[(cells.length / 2)] = 1;
		}else { // Put two seeds in the first generation if length is even
			cells[(cells.length / 2)] = 1;
			cells[(cells.length / 2) - 1] = 1;
		}

		int[] nextGen = new int[cells.length];
		int left;
		int mid;
		int right;

		for (int j = 0; j < cells.length; j++) {
			printResult(cells);
			for (int i = 0; i < (cells.length); i++) {
				mid = cells[i];
				if (i == 0) { // If our middle cell is at the start of the array
					left = cells[cells.length - 1];
					right = cells[i + 1];
				}else if (i == (cells.length - 1)) { // If our middle is at the end of the array
					left = cells[i - 1];
					right = cells[0];
				}else {
					left = cells[i - 1];
					right = cells[i + 1];
				}
				nextGen[i] = rules(left, mid, right); // Set the generated generation
			}
			copyArray(nextGen, cells);
		}
	}


	// Rules for Cellular Automaton (must reverse ruleSet)
	public static int rules(int a, int b, int c) {
		String str = "" + a + b + c;
		int index = Integer.parseInt(str, 2); // Argument '2' means that we want to parse a base 2 binary
		return ruling[index];
	}

	//  Print all the generations
	public static void printResult(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
		}
		System.out.println();
	}

	// Copy the contents of an integer array to another integer array
	public static void copyArray(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
	}
}