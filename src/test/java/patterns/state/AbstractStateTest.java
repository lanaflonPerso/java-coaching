
package patterns.state;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import lombok.extern.slf4j.Slf4j;

/**
 * class AbstractStateTest.
 */
@Slf4j
public final class AbstractStateTest {

    /**
     * Unit Test to abstract state.
     */
    @Test
    public void testAbstractState() {
        final StateAlice stateAlice = new StateAlice();
        assertNotNull(stateAlice);
        final StateBob stateBob = new StateBob();
        assertNotNull(stateBob);
    }

}
