
package coaching.tuples;

/**
 * Example of Boxing class for the generic type T.
 *
 * Boxing is an effective way of adapting the behaviour of a type.
 *
 * @param <T> the generic type
 */
public class Box<T> {

    /** The boxed Object t of type T. */
    protected T t;

    /**
     * Instantiates a new box.
     */
    public Box() {
        super();
    }

    /**
     * Instantiates a new box.
     *
     * @param t the type T
     */
    public Box(final T t) {
        super();
        this.t = t;
    }

    /**
     * Sets the value.
     *
     * @param t the type T
     */
    public void set(final T t) {
        this.t = t;
    }

    /**
     * Gets the value.
     *
     * @return the t as type T
     */
    public T get() {
        return this.t;
    }

    /**
     * Checks if is equal.
     *
     * @param t the t
     * @return true, if is equal
     */
    public boolean isEqual(final T t) {
        return this.t.equals(t);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [T=%s]", this.getClass().getSimpleName(), this.t);
    }

}
