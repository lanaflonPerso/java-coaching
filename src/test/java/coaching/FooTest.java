
package coaching;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for the logging the class loaders.
 */
public final class FooTest {

    /** Provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(FooTest.class);

    /**
     * Unit test to.
     */
    @Test
    public void testShowClassLoader() {
        LOG.info("this.getClass().getClassLoader() : {}", this.getClass().getClassLoader());
        LOG.info("Thread.currentThread().getContextClassLoader() : {}", Thread.currentThread().getContextClassLoader());
    }

}
