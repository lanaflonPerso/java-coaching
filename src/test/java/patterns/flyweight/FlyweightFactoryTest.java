

package patterns.flyweight;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The FlyweightFactoryTest Class.
 */
public class FlyweightFactoryTest {

	/**
	 * Unit Test to create.
	 */
	@Test
	public void testCreate() {
		final FlyweightFactory flyweightFactory = new FlyweightFactory();
		assertNotNull("Value cannot be null", flyweightFactory);
		final FlyWeight flyweight = flyweightFactory.create();
		assertNotNull("Value cannot be null", flyweight);
	}

}
