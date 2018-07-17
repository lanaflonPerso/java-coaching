
package coaching.pool;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the BlockingPool class.
 */
public final class BlockingPoolTest {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory
        .getLogger(BlockingPoolTest.class);

    /**
     * TestResourcePool Class.
     */
    public final class TestResourcePool extends AbstractBlockingPool<Boolean> {
    }

    /**
     * Test blocking pool.
     */
    @Test
    public void testBlockingPool() {
        final TestResourcePool resourcePool = new TestResourcePool();
        assertNotNull(resourcePool);
        LOG.info(resourcePool.toString());
    }

    /**
     * Unit test typical usage..
     */
    @Test
    public void testTypicalUsage() {
        // Given a resource pool
        final TestResourcePool testResourcePool = new TestResourcePool();
        assertNotNull(testResourcePool);
        testResourcePool.add(true);
        testResourcePool.add(false);
        assertEquals(2, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());

        // * pool
        while (testResourcePool.countFree() > 0) {
            final Boolean bool = testResourcePool.take();
            if (bool) {
                testResourcePool.remove(bool);
            }
        }

        // Then
        assertEquals(0, testResourcePool.countFree());
        assertEquals(1, testResourcePool.countUsed());
    }

}
