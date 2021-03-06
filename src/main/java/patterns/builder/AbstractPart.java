
package patterns.builder;

/**
 * Part class.
 */
public abstract class AbstractPart {

    /** The part name. */
    private final String partName;

    /**
     * Default Constructor.
     */
    public AbstractPart() {
        super();
        this.partName = this.getClass().getSimpleName();
    }

    /**
     * Default Constructor.
     *
     * @param partName the part name
     */
    public AbstractPart(final String partName) {
        super();
        this.partName = partName;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [partName=%s]", this.getClass().getSimpleName(), this.partName);
    }

}
