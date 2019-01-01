
package coaching.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class DaemonThread.
 */
public final class DaemonThread extends Thread {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(DaemonThread.class);

    /** Instantiate the single instance of this class. */
    private static final DaemonThread INSTANCE = new DaemonThread();

    /**
     * Returns this single shared instance.
     *
     * @return the singleton
     */
    public static DaemonThread getSingleton() {
        return INSTANCE;
    }

    /**
     * Private constructor prevents wild instantiations.
     */
    private DaemonThread() {
        super();
        setDaemon(true);
        LOG.info("{} loaded...", this.getClass().getSimpleName());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        LOG.info("{} running... ", this.getClass().getSimpleName());
        LOG.info("sleep 500 at {} ", System.currentTimeMillis());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOG.error(e.getLocalizedMessage(), e);
            currentThread().interrupt();
        }
        LOG.info("until {} ", System.currentTimeMillis());
        yield();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Thread#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [id=%s, name=%s, state=%s, priority=%s, isAlive=%s, isDaemon=%s]", getClass(), getId(), getName(), getState(), getPriority(), isAlive(), isDaemon());
    }

}
