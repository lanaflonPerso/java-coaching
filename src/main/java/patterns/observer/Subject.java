
package patterns.observer;

/**
 * Subject Class.
 */
public final class Subject extends AbstractSubject {

    /** The status. */
    private Boolean status = false;

    /**
     * status.
     *
     * @return the status
     */
    public Boolean getStatus() {
        return this.status;
    }

    /**
     * status.
     *
     * @param status the new status
     */
    public void setStatus(final Boolean status) {
        this.status = status;
        updateObservers();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [status=%s]", this.getClass().getSimpleName(), this.status);
    }

}
