
package coaching.pool;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit tests for the AbstractResourcePoolTest class.
 */


@Slf4j
public final class AbstractResourcePoolTest {

    /**
     * TestResourcePool Class.
     */
    public final class MockResourcePool extends AbstractResourcePool<Boolean> {
    }

    /**
     * Test abstract resource pool constructor.
     */
    @Test
    public void testAbstractResourcePool() {
        log.debug("testAbstractResourcePool");
        assertNotNull(new MockResourcePool());
    }

    /**
     * Test abstract resource pool typical usage.
     */
    @Test
    public void testTypicalUsage() {
        log.debug("testTypicalUsage");

        // Given a resource pool
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertNotNull(testResourcePool);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
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

    /**
     * Test add element to abstract resource pool.
     */
    @Test
    public void testAdd() {
        log.debug("testAdd");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        assertNotNull(testResourcePool.add(true));
        assertNotNull(testResourcePool.add(false));
        assertEquals(2, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
    }

    /**
     * Test remove abstract resource pool.
     */
    @Test
    public void testRemove() {
        log.debug("testRemove");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        testResourcePool.add(true);
        testResourcePool.add(false);
        assertEquals(2, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
    }

    /**
     * Test offer abstract resource pool.
     */
    @Test
    public void testOffer() {
        log.debug("testOffer");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertNotNull(testResourcePool);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        assertTrue(testResourcePool.offer(true));
        assertTrue(testResourcePool.offer(false));
        assertEquals(2, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
    }

    /**
     * Test remove from abstract resource pool when null.
     */
    @Test
    public void testRemoveWhenNull() {
        log.debug("testRemoveWhenNull");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertNotNull(testResourcePool);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        assertNotNull(testResourcePool.remove(null));
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
    }

    /**
     * Test get from abstract resource pool when empty.
     */
    @Test
    public void testGetWhenEmpty() {
        log.debug("testGetWhenEmpty");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertNotNull(testResourcePool);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        assertNull(testResourcePool.take());
        assertNull(testResourcePool.take());
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
    }

    /**
     * Test get from abstract resource pool.
     */
    @Test
    public void testGet() {
        log.debug("testGet");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertNotNull(testResourcePool);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        testResourcePool.add(true);
        testResourcePool.add(false);
        assertNotNull(testResourcePool.take());
        assertNotNull(testResourcePool.take());
        assertNull(testResourcePool.take());
        assertEquals(0, testResourcePool.countFree());
        assertEquals(2, testResourcePool.countUsed());
    }

    /**
     * Test release from abstract resource pool.
     */
    @Test
    public void testRelease() {
        log.debug("testRelease");
        final MockResourcePool testResourcePool = new MockResourcePool();
        assertNotNull(testResourcePool);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(0, testResourcePool.countUsed());
        testResourcePool.add(true).add(false);
        assertTrue(testResourcePool.take() != null);
        assertTrue(testResourcePool.take() != null);
        assertTrue(testResourcePool.take() == null);
        assertEquals(0, testResourcePool.countFree());
        assertEquals(2, testResourcePool.countUsed());
    }

}
