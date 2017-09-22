package coaching.exceptions;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import coaching.exceptions.CustomExceptionHandling.*;

/**
 * Custom Exception Handling Test class.
 */
public class CustomExceptionHandlingTest {

	/**
	 * Unit Test to sub process A.
	 *
	 * @throws CustomCreationException the custom creation exception
	 */
	@Test(expected = CustomCreationException.class)
	public void testSubProcessA() throws CustomCreationException {
		final CustomExceptionHandling customExceptionHandling = new CustomExceptionHandling();
		assertNotNull(customExceptionHandling);
		customExceptionHandling.subProcessA();
	}

	/**
	 * Unit Test to sub process B.
	 *
	 * @throws CustomReadException the custom read exception
	 */
	@Test(expected = CustomReadException.class)
	public void testSubProcessB() throws CustomReadException {
		final CustomExceptionHandling customExceptionHandling = new CustomExceptionHandling();
		assertNotNull(customExceptionHandling);
		customExceptionHandling.subProcessB();
	}

	/**
	 * Unit Test to sub process C.
	 *
	 * @throws CustomUpdateException the custom update exception
	 */
	@Test(expected = CustomUpdateException.class)
	public void testSubProcessC() throws CustomUpdateException {
		final CustomExceptionHandling customExceptionHandling = new CustomExceptionHandling();
		assertNotNull(customExceptionHandling);
		customExceptionHandling.subProcessC();
	}

	/**
	 * Unit Test to process.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testProcess() throws Exception {
		final CustomExceptionHandling customExceptionHandling = new CustomExceptionHandling();
		assertNotNull(customExceptionHandling);
		customExceptionHandling.process();
	}

}