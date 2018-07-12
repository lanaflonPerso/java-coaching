
package coaching.automation;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import coaching.automation.PlatformData;

/**
 * The Class ExpectedDataTest.
 */
public class ExpectedDataTest {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ExpectedDataTest.class);

    /**
     * Unit test to on platform.
     */
    @Test
    public void testOnPlatform() {
        PlatformData expectedData;

        expectedData = new PlatformData("local");
        assertNotNull(expectedData);
        LOG.info(expectedData.toString());

        expectedData = PlatformData.platform("local");
        assertNotNull(expectedData);
        LOG.info(expectedData.toString());

        String tagged = expectedData.getTagged("@foo");
        assertNull(tagged);
        assertNull(expectedData.getTagged("@bar"));
    }

    /**
     * Unit test to default platform domain language.
     */
    @Test
    public void testDefaultPlatformDomainLanguage() {
        assertNotNull(PlatformData.withTag("@AUTHORISED"));
        assertNotNull(PlatformData.withTag("@UNAUTHORISED"));
        assertNotNull(PlatformData.withCharacteristic("@AUTHORISED"));
        assertNotNull(PlatformData.withCharacteristic("@UNAUTHORISED"));
        assertNull(PlatformData.withTag("@tag"));

        assertNotNull(PlatformData.allWithTag("@AUTHORISED"));
        assertNotNull(PlatformData.allWithTag("@UNAUTHORISED"));
        assertNull(PlatformData.allWithTag("@tag"));
    }

}
