package idioms;

/**
 * Enum Example with textValues.
 */
public enum EnumExample {

	Unknown("Unknown"), Heads("Heads"), Tails("Tails");

	private String textValue;

	/**
	 * Instantiates a new enum example.
	 *
	 * @param textValue the text value
	 */
	EnumExample(String textValue) {
		this.textValue = textValue;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return this.textValue;
	}

	/**
	 * Factory method Enum value from string.
	 *
	 * @param textValue the text value
	 * @return the enum example
	 */
	public static EnumExample fromString(String textValue) {
		for (final EnumExample instance : EnumExample.values()) {
			if (instance.textValue.equalsIgnoreCase(textValue)) {
				return instance;
			}
		}
		return null;
	}
}
