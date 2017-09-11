
package patterns.interpreter;

/**
 * The OrExpression Class.
 */
public class OrExpression extends NonTerminalExpression {

	private AbstractExpression expr1 = null;
	private AbstractExpression expr2 = null;

	/**
	 * Instantiates a new or expression.
	 *
	 * @param expr1 the expr 1
	 * @param expr2 the expr 2
	 */
	public OrExpression(final AbstractExpression expr1, final AbstractExpression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	/* (non-Javadoc)
	 * @see patterns.interpreter.NonTerminalExpression#interpret(patterns.interpreter.ContextInterface)
	 */
	@Override
	public boolean interpret(final ContextInterface context) {
		return expr1.interpret(context) || expr2.interpret(context);
	}

}
