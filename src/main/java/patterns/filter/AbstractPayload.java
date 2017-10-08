
package patterns.filter;

import java.io.*;
import java.util.*;

/**
 * AbstractPayload Class.
 */
public class AbstractPayload implements PayloadInterface {

	private final Properties properties = new Properties();

	/**
	 * Instantiates a new abstract payload.
	 */
	public AbstractPayload() {
		super();
	}

	/**
	 * property.
	 *
	 * @param key the key
	 * @param value the value
	 * @return the abstract payload
	 */
	public AbstractPayload setProperty(final String key, final String value) {
		this.properties.setProperty(key, value);
		return this;
	}

	/**
	 * property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public String getProperty(final String key) {
		return this.properties.getProperty(key);
	}

	/**
	 * property.
	 *
	 * @param key the key
	 * @param defaultValue the default value
	 * @return the property
	 */
	public String getProperty(final String key, final String defaultValue) {
		return this.properties.getProperty(key, defaultValue);
	}

	/**
	 * Load.
	 *
	 * @param inputStream the in stream
	 * @return the abstract payload
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public AbstractPayload load(final InputStream inputStream) throws IOException {
		this.properties.load(inputStream);
		return this;
	}

	/**
	 * Load from XML.
	 *
	 * @param inputStream the in
	 * @return the abstract payload
	 * @throws IOException Signals that an I/O exception has occurred.
	 *             invalid properties format exception
	 * @throws InvalidPropertiesFormatException the invalid properties format
	 *             exception
	 */
	public AbstractPayload loadFromXML(final InputStream inputStream)
	        throws IOException, InvalidPropertiesFormatException {
		this.properties.loadFromXML(inputStream);
		return this;

	}

	/**
	 * Store.
	 *
	 * @param outputStream the out
	 * @return the abstract payload
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public AbstractPayload store(final OutputStream outputStream) throws IOException {
		return this.store(outputStream, "");
	}

	/**
	 * Store.
	 *
	 * @param outputStream the out
	 * @param comments the comments
	 * @return the abstract payload
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public AbstractPayload store(final OutputStream outputStream, final String comments) throws IOException {
		this.properties.store(outputStream, comments);
		return this;
	}

}
