
package associations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The AbstractEngine Class.
 */
public abstract class AbstractEngine implements FuelInterface {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	protected FuelInterface fuel;

	public AbstractEngine(FuelInterface fuel) {
		super();
		useFuel(fuel);
	}

	/**
	 * Use fuel.
	 *
	 * @param fuel the fuel
	 */
	public void useFuel(FuelInterface fuel) {
		this.fuel = fuel;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see associations.Fuel#fuelUp(associations.Fuel)
	 */
	public void fuelUp(FuelInterface fuel) {
		fuel.fuelUp(fuel);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Engine [fuel=" + this.fuel + "]";
	}

}
