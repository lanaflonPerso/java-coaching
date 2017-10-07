

package patterns.command;

/**
 * AbstractPredicate Class.
 */
public abstract class AbstractPredicate implements CommandInterface {

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.command.CommandInterface#execute(patterns.command.
	 * ParametersInterface)
	 */
	@Override
	public abstract ResultInterface execute(ParametersInterface commandParameters);

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.command.CommandInterface#undo(patterns.command.
	 * ParametersInterface)
	 */
	@Override
	public abstract ResultInterface undo(ParametersInterface commandParameters);

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.command.CommandInterface#result()
	 */
	@Override
	public abstract Boolean result();

}
