
package coaching.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Table Cell class.
 */
public class TableCell {

    /** provides logging. */
    protected final Logger log = LoggerFactory
        .getLogger(this.getClass().getSimpleName());

    /** The value. */
    private String value = "";

    /**
     * Instantiates a new table cell.
     */
    public TableCell() {
        super();
    }

    /**
     * Instantiates a new table cell.
     *
     * @param value
     *            the value
     */
    public TableCell(final String value) {
        super();
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value
     *            the value to set
     * @return the table cell
     */
    public TableCell setValue(final String value) {
        this.value = value;
        return this;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        final String message = String
            .format("%s [value=%s]",
                    this.getClass().getSimpleName(),
                    value);
        log.trace(message);
        return message;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return value;
    }

}
