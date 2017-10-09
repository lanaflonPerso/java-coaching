/**
 *  @title			ObjectTypes .java
 *  @description	Example usage of built in Java object types.
 *  @author			martin.spamer.
 *  @version		0.1 - first release.
 *	Created			07-Oct-2004 - 09:20:22
 **/

package coaching.types;

import org.slf4j.*;

/**
 * Examples of Java Object Types.
 */
public class ObjectTypes {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	// integers object types
	private final Byte largestByte = Byte.MAX_VALUE;
	private final Byte smallestByte = Byte.MIN_VALUE;

	private final Short largestShort = Short.MAX_VALUE;
	private final Short smallestShort = Short.MIN_VALUE;

	private final Integer largestInteger = Integer.MAX_VALUE;
	private final Integer smallestInteger = Integer.MIN_VALUE;

	private final Long largestLong = Long.MAX_VALUE;
	private final Long smallesttLong = Long.MIN_VALUE;

	// real number object types.
	private final Float largestFloat = Float.MAX_VALUE;
	private final Float smallestFloat = Float.MIN_VALUE;

	private final Double largestDouble = Double.MAX_VALUE;
	private final Double smallestDouble = Double.MIN_VALUE;

	// other primitive types
	private final Character aChar = 'A';

	private final Boolean trueBoolean = true;
	private final Boolean falseBoolean = false;

	/**
	 * Display.
	 */
	public void display() {
		// display them all
		this.log.info("largest byte value : {}", this.largestByte);
		this.log.info("smallest byte value : {}", this.smallestByte);

		this.log.info("largest short value is {}", this.largestShort);
		this.log.info("smallest short value is {}", this.smallestShort);

		this.log.info("largest integer value is {}", this.largestInteger);
		this.log.info("smallest integer value is {}", this.smallestInteger);

		this.log.info("largest long value is {}", this.largestLong);
		this.log.info("smallest long value is {}", this.smallesttLong);

		this.log.info("largest float value is {}", this.largestFloat);
		this.log.info("smallest float value is {}", this.smallestFloat);

		this.log.info("largest double value is {}", this.largestDouble);
		this.log.info("smallest double value is {}", this.smallestDouble);

		if (Character.isUpperCase(this.aChar)) {
			this.log.info("The character {} is upper case.", this.aChar);
		}

		if (this.trueBoolean) {
			this.log.info("aBooleanTrue has tested as true : {}", this.trueBoolean);
		}

		if (this.falseBoolean == false) {
			this.log.info("aFalseBoolean has tested as false value : {}", this.falseBoolean);
		}
	}
}
