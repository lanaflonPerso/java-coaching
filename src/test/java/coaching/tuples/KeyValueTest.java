
package coaching.tuples;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class KeyValueTest {

    private static final Logger LOG = LoggerFactory
        .getLogger(KeyValueTest.class);

    @Test
    public void testKeyValue() {
        final String key = new String();
        final Boolean value = true;
        final KeyValue<String, Boolean> keyValue = new KeyValue<String, Boolean>(
                key, value);
        assertNotNull(keyValue);
        LOG.info("{}", keyValue);
    }

}
