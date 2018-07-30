
package coaching.mvc.controller;

import java.util.HashMap;

import coaching.mvc.CommandInterface;

/**
 * A collection of Commands.
 */
public final class Commands extends HashMap<String, Command> {

    /** The instance. */
    private static Commands instance;

    /**
     * single instance of CommandPool.
     *
     * @return single instance of CommandPool
     */
    public static Commands getInstance() {
        if (Commands.instance == null) {
            Commands.instance = new Commands();
        }
        return Commands.instance;
    }

    /**
     * Creates the new command.
     *
     * @return the command pool
     */
    public static CommandInterface create() {
        return new Command();
    }

    /**
     * Instantiates a new command pool.
     */
    private Commands() {
        super();
    }

}