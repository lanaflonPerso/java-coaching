/**
 *  @title       BasicElement.java
 *  @description TODO
 *  @author      martin.spamer.
 *  @version     0.1 - first release.
 *	Created      23-Sep-2004
 *
 **/

package coaching.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BasicElement Class.
 */
public abstract class AbstractElement {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * Constructor instantiates a new basic element.
	 */
	public AbstractElement() {
		this.log.info("{} default constructor", this.getClass().getName());
	}

	/**
	 * execute.
	 */
	public void execute() {
		this.log.info("{}.execute", this.getClass().getName());
	}

	@Override
	public String toString() {
		return String.format("%s", this.getClass().getSimpleName());
	}
}
