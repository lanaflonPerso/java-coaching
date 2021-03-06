
package coaching.bags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * Simple Bag class.
 */
@SuppressWarnings("serial")


@Slf4j
public class SimpleBag extends ArrayList<String> implements BagInterface {

    /** The random. */
    private final Random random = new Random();

    /** The initial state. */
    private String[] initialState = new String[0];

    /**
     * Instantiates a new empty bag.
     */
    public SimpleBag() {
        super();
        log.info("SimpleBag()");
        fill(this.initialState);
    }

    /**
     * Instantiates a new bag from string array.
     *
     * values varargs
     *
     * @param values the values
     */
    public SimpleBag(final String... values) {
        super();
        log.info("SimpleBag({})", Arrays.toString(values));
        fill(values == null ? new String[0] : values);
    }

    /*
     * (non-Javadoc)
     * @see coaching.bags.BagInterface#fill(java.lang.String[])
     */
    @Override
    public BagInterface fill(final String... values) {
        if (values != null) {
            this.initialState = values;
            this.addAll(Arrays.asList(values));
        }
        return this;
    }

    /*
     * (non-Javadoc)
     * @see coaching.bags.BagInterface#pick()
     */
    @Override
    public String pick() {
        log.debug("{}.choose()", this.getClass().getSimpleName());
        final int size = size();
        if (size > 0) {
            final int nextInt = this.random.nextInt(size);
            return this.remove(nextInt);
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see coaching.bags.BagInterface#reset()
     */
    @Override
    public BagInterface reset() {
        log.debug("{}.reset()", this.getClass().getSimpleName());
        return fill(this.initialState);
    }

}
