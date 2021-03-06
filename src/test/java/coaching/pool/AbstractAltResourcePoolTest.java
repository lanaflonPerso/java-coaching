
package coaching.pool;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeTrue;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit test class for AbstractAltResourcePool.
 */


@Slf4j
public class AbstractAltResourcePoolTest {
    /**
     * The ValueObject class.
     */
    public class ValueObject extends AbstractValueObject {
    }

    /**
 * The MockResourcePool.
     */
    public class MockResourcePool extends AbstractAltResourcePool<ValueObject> {
        /*
         * (non-Javadoc)
         * @see coaching.pool.AbstractAltResourcePool#create()
         */
        @Override
        public ValueObject create() throws ResourceCreationException {
            return new ValueObject();
        }
    }

    /**
     * Unit test to default constructor.
     *
     * @throws ResourceBorrowException the resource borrow exception
     */
    @Test
    public void testDefaultConstructor() throws ResourceBorrowException {
        log.debug("testAbstractResourcePool");
        MockResourcePool pool = new MockResourcePool();
        assertNotNull(pool);
        ValueObject obj = pool.borrow();
        pool.release(obj);
    }

    /**
     * Unit test to discard.
     */
    @Test
    public void testDiscard() {
        assumeTrue("Not yet implemented", false);
    }

    /**
     * Unit test to grow.
     */
    @Test
    public void testGrow() {
        assumeTrue("Not yet implemented", false);
    }

    /**
     * Unit test to shrink.
     */
    @Test
    public void testShrink() {
        assumeTrue("Not yet implemented", false);
    }

}
