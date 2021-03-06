
package coaching.types;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import coaching.arrays.ObjectTypesArray;

/**
 * The ObjectTypesArrayTest class.
 */
public final class ObjectTypesArrayTest {

    /**
     * Unit Test to display.
     */
    @Test
    public void testDisplayObjectArray() {
        final ObjectTypesArray objectArray = new ObjectTypesArray();
        assertNotNull(objectArray);
        objectArray.display();
    }

    /**
     * Unit Test to display.
     */
    @Test
    public void testDisplayMatrix() {
        final ObjectTypesArray objectArray = new ObjectTypesArray();
        assertNotNull(objectArray);
        objectArray.displayMatrix();
    }

    /**
     * Unit Test to display.
     */
    @Test
    public void testIterateArray() {
        final ObjectTypesArray objectArray = new ObjectTypesArray();
        assertNotNull(objectArray);
        objectArray.iterateArray();
    }
}
