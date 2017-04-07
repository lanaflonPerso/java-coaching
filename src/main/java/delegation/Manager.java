
package delegation;

/**
 * The Manager Class.
 */
class Manager implements ProcessInterface {

	/** The worker. */
	private Worker worker;

	/**
	 * Instantiates a new manager.
	 */
	public Manager() {
		super();
		this.worker = new Worker();
	}

	/**
	 * Sets the worker.
	 *
	 * @param worker the new worker
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see delegation.ProcessInterface#doProcess()
	 */
	public Manager doProcess() {
		this.worker.doProcess();
		return this;
	}

}
