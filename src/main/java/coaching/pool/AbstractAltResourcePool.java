
package coaching.pool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * AbstractResourcePool Class.
 *
 * @param <T> the generic type T
 */


@Slf4j
public abstract class AbstractAltResourcePool<T> {

    /** The max pool size. */
    protected int maxPoolSize = Integer.MAX_VALUE;

    /** The default pool size. */
    protected int defaultPoolSize = Integer.MAX_VALUE;

    /** The min pool size. */
    protected int minPoolSize = Integer.MIN_VALUE;

    /** The free pool. */
    protected Deque<T> freePool = new ArrayDeque<T>();

    /** The used pool. */
    protected Set<T> usedPool = new HashSet<>();

    /**
     * Borrow resource from pool.
     *
     * @return the t
     * @throws ResourceBorrowException the resource borrow exception
     */
    public synchronized T borrow() throws ResourceBorrowException {
        T resource = null;

        // pool of free resources is empty
        if (this.freePool.isEmpty()) {
            // threshold
            if (this.usedPool.size() < this.maxPoolSize) {
                // make a new object
                try {
                    resource = create();
                } catch (final ResourceCreationException e) {
                    log.error(e.getLocalizedMessage(), e);
                    throw new ResourceBorrowException(e);
                }
            } else {
                log.info("Used({}) < maxPoolSize({})", this.usedPool.size(), this.maxPoolSize);
            }
        } else {
            // first valid resource
            resource = this.freePool.pop();

            // used resource pool.
            this.usedPool.add(resource);
        }
        return resource;
    }

    /**
     * Allows pool to create resources to re-populate the pool.
     *
     * @return the t
     * @throws ResourceCreationException the resource creation exception
     */
    public abstract T create() throws ResourceCreationException;

    /**
     * Discard a resource to the pool.
     *
     * @param resource the resource
     */
    public synchronized void discard(final T resource) {
        // in use pool.
        this.usedPool.remove(resource);
    }

    /**
     * Grow the pool.
     *
     * @param growthRate the growth rate
     */
    public synchronized void grow(final int growthRate) {
        this.defaultPoolSize += growthRate;
    }

    /**
     * Release a resource back to pool.
     *
     * @param resource the resource
     */
    public synchronized void release(final T resource) {
        // * in use pool.
        this.usedPool.remove(resource);

        // * free pool
        this.freePool.push(resource);
    }

    /**
     * Shrink the pool size.
     *
     * @param shrinkRate the shrink rate
     */
    public synchronized void shrink(final int shrinkRate) {
        this.defaultPoolSize -= shrinkRate;
    }

}
