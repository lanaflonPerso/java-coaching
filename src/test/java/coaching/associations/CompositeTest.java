

package coaching.associations;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

import coaching.associations.*;
import coaching.model.*;

/**
 * class CompositeTest.
 */
public class CompositeTest {

	private static final Logger LOG = LoggerFactory.getLogger(CompositeTest.class);

	/**
	 * Unit Test to composite.
	 */
	@Test
	public void testComposite() {
		final Composite composite = new Composite();
		assertNotNull("Value cannot be null", composite);
		LOG.info("{}", composite);
	}

	/**
	 * Unit Test to composite alice bob charlie dan.
	 */
	@Test
	public void testCompositeAliceBobCharlieDan() {
		final Alice alice = new Alice();
		final Bob bob = new Bob();
		final Charlie charlie = new Charlie();
		final Dan dan = new Dan();
		final Composite composite = new Composite(alice, bob, charlie, dan);
		assertNotNull("Value cannot be null", composite);
		LOG.info("{}", composite);
	}

}