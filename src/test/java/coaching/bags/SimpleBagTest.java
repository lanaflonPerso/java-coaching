
package coaching.bags;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import coaching.tuples.BoxTest;

/**
 * Unit test examples for a Bag class.
 */
public final class SimpleBagTest {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(BoxTest.class);

    /** The Constant VALUES. */
    private static final String[] VALUES = { "Cat", "Dog", "Rabbit" };

    /**
     * Unit Test to bag.
     */
    @Test
    public void testBag() {
        LOG.info("testBag()");
        final BagInterface bag = new SimpleBag();
        assertNotNull(bag);
    }

    /**
     * Unit Test to bag string array.
     */
    @Test
    public void testBagStringArray() {
        LOG.info("testBagStringArray()");
        final SimpleBag bag = new SimpleBag(VALUES);
        assertNotNull(bag);
        verify(bag);
    }

    /**
     * Unit Test to bag vargs.
     */
    @Test
    public void testBagVargs() {
        LOG.info("testBagVargs()");
        final SimpleBag bag = new SimpleBag("Cat", "Dog", "Rabbit");
        assertNotNull(bag);
        verify(bag);
    }

    /**
     * Unit Test to fill.
     */
    @Test
    public void testFill() {
        LOG.info("testFill()");
        final SimpleBag bag = new SimpleBag();
        assertNotNull(bag);
        bag.fill(VALUES);
        verify(bag);
    }

    /**
     * Unit Test to vargs.
     */
    @Test
    public void testVargs() {
        LOG.info("testVargs()");
        final SimpleBag bag = new SimpleBag();
        assertNotNull(bag);
        bag.fill("Cat", "Dog", "Rabbit");
        verify(bag);
    }

    /**
     * Test exhausted bag.
     */
    @Test
    public void testExhaustedBag() {
        LOG.info("testExhaustedBag()");
        final String[] stuff = { "Cat", "Dog", "Rabbit" };
        final SimpleBag bag = new SimpleBag(stuff);
        assertNotNull(bag);
        verify(bag);
    }

    /**
     * Verify that.
     *
     * @param bag the bag
     */
    private void verify(final SimpleBag bag) {
        assertNotNull(bag);
        assertEquals(3, bag.size());
        String choice = bag.choose();
        assertNotNull(choice);
        LOG.info(choice);
        assertEquals(2, bag.size());

        choice = bag.choose();
        assertNotNull(choice);
        LOG.info(choice);
        assertEquals(1, bag.size());

        choice = bag.choose();
        assertNotNull(choice);
        LOG.info(choice);
        assertEquals(0, bag.size());
    }

    /**
     * Unit Test to choose.
     */
    @Test
    public void testChooseFromBag() {
        LOG.info("testChooseFromBag()");
        final BagInterface bag = new SimpleBag(VALUES);
        assertNotNull(bag);
        final String chosen = bag.choose();
        assertNotNull(chosen);
        final String pick = bag.pick();
        assertNotNull(pick);
        assertEquals(bag, bag.reset());
    }

    /**
     * Test null bag.
     */
    @Test
    public void testNullBag() {
        LOG.info("testNullBag()");
        final String[] stuff = null;
        final SimpleBag bag = new SimpleBag(stuff);
        assertEquals(0, bag.size());
        final String choice = bag.choose();
        assertNull(choice);
        assertEquals(0, bag.size());
    }

    /**
     * Test empty bag.
     */
    @Test
    public void testEmptyBag() {
        LOG.info("testEmptyBag()");
        final String[] stuff = new String[0];
        final SimpleBag bag = new SimpleBag(stuff);
        assertEquals(0, bag.size());
        final String choice = bag.choose();
        assertNull(choice);
        assertEquals(0, bag.size());
    }

}
