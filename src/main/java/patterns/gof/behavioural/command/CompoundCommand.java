
package patterns.gof.behavioural.command;

/**
 * The CompoundCommand Class.
 */
public class CompoundCommand extends AbstractCommand {

	@Override
	public AbstractCommand execute() {
		return this;
	}

}