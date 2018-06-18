
package coaching.bags;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coaching.tuples.BoxTest;

/**
 * Unit Test examples for a Bag Class.
 */
public class SimpleBagTest {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(BoxTest.class);

    /** The Constant VALUES. */
    private static final String[] VALUES = { "Cat", "Dog", "Rabbit" };

    /**
     * Unit Test to bag.
     */
    @Test
    public void testBag() {
        final BagInterface bag = new SimpleBag();
        assertNotNull("Value cannot be null", bag);
    }

    /**
     * Unit Test to bag string array.
     */
    @Test
    public void testBagStringArray() {
        final SimpleBag bag = new SimpleBag(VALUES);
        assertNotNull("Value cannot be null", bag);
        verify(bag);
    }

    /**
     * Unit Test to bag array.
     */
    @Test
    public void testBagArray() {
        final String[] stuff = { "Cat", "Dog", "Rabbit" };
        final SimpleBag bag = new SimpleBag(stuff);
        assertNotNull("Value cannot be null", bag);
        verify(bag);
    }

    /**
     * Unit Test to bag vargs.
     */
    @Test
    public void testBagVargs() {
        final SimpleBag bag = new SimpleBag("Cat", "Dog", "Rabbit");
        assertNotNull("Value cannot be null", bag);
        verify(bag);
    }

    /**
     * Unit Test to fill.
     */
    @Test
    public void testFill() {
        final SimpleBag bag = new SimpleBag();
        assertNotNull("Value cannot be null", bag);
        bag.fill(VALUES);
        verify(bag);
    }

    /**
     * Unit Test to vargs.
     */
    @Test
    public void testVargs() {
        final SimpleBag bag = new SimpleBag();
        assertNotNull("Value cannot be null", bag);
        bag.fill("Cat", "Dog", "Rabbit");
        verify(bag);
    }

    /**
     * Test exhausted bag.
     */
    @Test
    public void testExhaustedBag() {
        final String[] stuff = { "Cat", "Dog", "Rabbit" };
        final SimpleBag bag = new SimpleBag(stuff);
        assertNotNull("Value cannot be null", bag);
        verify(bag);
    }

    /**
     * Verify that.
     *
     * @param bag
     *            the bag
     */
    private void verify(final SimpleBag bag) {
        assertNotNull("Value cannot be null", bag);
        assertEquals(3, bag.size());
        String choice = bag.choose();
        assertNotNull("Value cannot be null", choice);
        LOG.info(choice);
        assertEquals(2, bag.size());

        choice = bag.choose();
        assertNotNull("Value cannot be null", choice);
        LOG.info(choice);
        assertEquals(1, bag.size());

        choice = bag.choose();
        assertNotNull("Value cannot be null", choice);
        LOG.info(choice);
        assertEquals(0, bag.size());
    }

    /**
     * Unit Test to choose.
     */
    @Test
    public void testChoose() {
        final BagInterface bag = new SimpleBag(VALUES);
        assertNotNull("Value cannot be null", bag);
        final String chosen = bag.choose();
        assertNotNull("Value cannot be null", chosen);
    }

    /**
     * Test null bag.
     */
    @Test
    public void testNullBag() {
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
        final String[] stuff = new String[0];
        final SimpleBag bag = new SimpleBag(stuff);
        assertEquals(0, bag.size());
        final String choice = bag.choose();
        assertNull(choice);
        assertEquals(0, bag.size());
    }

    /**
     * Test type.
     *
     * @throws Exception the exception
     */
    public void test_type() throws Exception {
        // TODO auto-generated by JUnit Helper.
        assertNotNull(SimpleBag.class);
    }

    /**
     * Test instantiation.
     *
     * @throws Exception the exception
     */
    public void test_instantiation() throws Exception {
        // TODO auto-generated by JUnit Helper.
        final SimpleBag target = new SimpleBag();
        assertNotNull(target);
    }

    /**
     * Test fill a$ string array.
     *
     * @throws Exception the exception
     */
    public void test_fill_A$StringArray() throws Exception {
        // TODO auto-generated by JUnit Helper.
        final SimpleBag target = new SimpleBag();
        final String[] values = new String[] {};
        final BagInterface actual = target.fill(values);
        final BagInterface expected = null;
        assertEquals(expected, actual);
    }

    /**
     * Test pick a$.
     *
     * @throws Exception the exception
     */
    public void test_pick_A$() throws Exception {
        // TODO auto-generated by JUnit Helper.
        final SimpleBag target = new SimpleBag();
        final String actual = target.pick();
        final String expected = null;
        assertEquals(expected, actual);
    }

    /**
     * Test choose a$.
     *
     * @throws Exception the exception
     */
    public void test_choose_A$() throws Exception {
        // TODO auto-generated by JUnit Helper.
        final SimpleBag target = new SimpleBag();
        final String actual = target.choose();
        final String expected = null;
        assertEquals(expected, actual);
    }

    /**
     * Test reset a$.
     *
     * @throws Exception the exception
     */
    public void test_reset_A$() throws Exception {
        // TODO auto-generated by JUnit Helper.
        final SimpleBag target = new SimpleBag();
        final BagInterface actual = target.reset();
        final BagInterface expected = null;
        assertEquals(expected, actual);
    }

}
