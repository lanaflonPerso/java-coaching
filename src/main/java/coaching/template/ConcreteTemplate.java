package coaching.template;

/**
 * Concrete Class.
 */
public final class ConcreteTemplate extends AbstractTemplate {

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.gof.behavioural.template_method.AbstractClass#
	 * primitiveOperationA()
	 */
	@Override
	public AbstractTemplate primitiveOperationAlice() {
		this.log.info("primitiveOperationAlice()");
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.gof.behavioural.template_method.AbstractClass#
	 * primitiveOperationB()
	 */
	@Override
	public AbstractTemplate primitiveOperationBob() {
		this.log.info("primitiveOperationBob()");
		return this;
	}

}