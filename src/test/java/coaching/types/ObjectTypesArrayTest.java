


package coaching.types;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import coaching.arrays.ObjectTypesArray;

/**
 * The ObjectTypesArrayTest Class.
 */
public class ObjectTypesArrayTest {

	/**
	 * Unit Test to display.
	 */
	@Test
	public void testDisplayObjectArray() {
		final ObjectTypesArray objectTypes = new ObjectTypesArray();
		assertNotNull("Value cannot be null", objectTypes);
		objectTypes.iterateArray();
	}

	/**
	 * Unit Test to display.
	 */
	@Test
	public void testDisplayMatrix() {
		final ObjectTypesArray objectTypes = new ObjectTypesArray();
		assertNotNull("Value cannot be null", objectTypes);
		objectTypes.displayMatrix();
	}

	/**
	 * Unit Test to display.
	 */
	@Test
	public void testDisplay() {
		final ObjectTypesArray objectTypes = new ObjectTypesArray();
		assertNotNull("Value cannot be null", objectTypes);
		objectTypes.display();
	}
}
