
package coaching.money;

import java.util.Currency;
import java.util.Locale;

/**
 * A class for Pounds as Money.
 */
public final class Pounds extends Money {

    /**
     * Instantiates a new pounds.
     */
    public Pounds() {
        super(Currency.getInstance(Locale.UK), 0);
    }

    /**
     * Instantiates a new pounds.
     *
     * @param amount the amount
     */
    public Pounds(final long amount) {
        super(Currency.getInstance(Locale.UK), amount);
    }
}
