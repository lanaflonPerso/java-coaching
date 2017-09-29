
package patterns.filter;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The FilterManagerTest Class.
 */
public class FilterManagerTest {

	/**
	 * Unit Test to filter manager.
	 */
	@Test
	public void testFilter() {
		final FilterAlice filterChain = new FilterAlice(new FilterBob(new FilterCharlie()));
		assertNotNull("Value cannot be null",filterChain);
		filterChain.handleRequest(new Payload());
	}

	/**
	 * Unit Test to filter manager.
	 */
	@Test
	public void testFilterManager() {
		final FilterManager filterManager = new FilterManager();
		assertNotNull("Value cannot be null",filterManager);
		filterManager.operation();
	}

}
