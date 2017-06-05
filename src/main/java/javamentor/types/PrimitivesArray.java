/**
 *  @title       PrimativeArray.java
 *  @description TODO
 *  @author      martin.spamer.
 *  @version     0.1 - first release.
 *	Created      23-Sep-2004
 *
 **/

package javamentor.types;

/**
 * Example code of arrays of primitive types.
 * @author martin.spamer
 * @version 0.1 - 11:25:50
 **/
public class PrimitivesArray {

	/**
	 * Main program entry point
	 * @param args array of command line parameters as Strings.
	 */
	public void display() {
		final int ARRAY_SIZE = 10;

		// Declare a reference to an array of longs.
		long[] values;

		/**
		 * point the reference to an Allocation of space for an array of longs
		 */
		values = new long[ARRAY_SIZE];

		// fill in some value
		// arrays index from zero
		values[0] = 0l;

		for (int i = 1; i < ARRAY_SIZE; i++) {
			// assign a value to an element of array
			values[i] = i * 100;
			System.out.println(i + "=" + values[i]);
		}

		// declare a reference to an matric of longs
		long[][] matrix;

		/**
		 * point the reference to an Allocation of space for an array of longs
		 */
		matrix = new long[ARRAY_SIZE][ARRAY_SIZE];

		for (int x = 0; x < ARRAY_SIZE; x++) {
			for (int y = 0; y < ARRAY_SIZE; y++) {
				// assign a value to an element of the matrix
				matrix[x][y] = x * y;
				System.out.print(matrix[x][y] + ",");
			}
			System.out.print("\n");
		}

		/**
		 * Declare and Initialise the array with static data
		 */
		final long[][] vector = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		for (int firstIndex = 0; firstIndex < 3; firstIndex++) {
			for (int secondIndex = 0; secondIndex < 3; secondIndex++) {
				System.out.print(vector[firstIndex][secondIndex]);
			}
			System.out.print("\n");
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final PrimitivesArray types = new PrimitivesArray();
		types.display();
	}

}