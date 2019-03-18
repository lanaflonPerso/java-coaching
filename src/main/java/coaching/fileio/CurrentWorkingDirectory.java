
package coaching.fileio;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CurrentWorkingDirectory Class.
 */
public final class CurrentWorkingDirectory {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(CurrentWorkingDirectory.class);

    /**
     * Instantiates a new current working directory.
     */
    public CurrentWorkingDirectory() {
        mark(this);
    }

    /**
     * Mark.
     *
     * @param that the that
     * @return the string
     */
    private String mark(final Object that) {
        String absolutePath = null;
        try {
            final String className = that.getClass().getSimpleName();
            final String fileName = String.format("./target/%s.CurrentWorkingDirectory", className);
            final File file = new File(fileName);
            try {
                file.createNewFile();
                absolutePath = file.getAbsolutePath();
                LOG.info(absolutePath);
            } catch (final Exception e) {
                LOG.error(e.getLocalizedMessage(), e);
            }
        } catch (final Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return absolutePath;
    }
}