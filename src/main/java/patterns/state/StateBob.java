
package patterns.state;

/**
 * StateZ Class.
 */
class StateBob extends AbstractState {

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.gof.behavioural.state.State#handle()
	 */
	@Override
	public void handle() {
		log.info("handle()");
	}

}