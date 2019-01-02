
package coaching.solid;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit Test for the Liskov Substitution Principle (LSP) example class.
 */
public final class LiskovSubstitutionPrincipleTest {

    /**
     * Unit Test for the Liskov substitution principle example class..
     */
    @Test
    public void testLiskovSubstitutionPrinciple() {
        final LiskovSubstitutionPrinciple lsp = new LiskovSubstitutionPrinciple();
        assertNotNull(lsp);
    }

}
