/**
 * Application.java
 *
 * Created on 30 June 2004 - 13:07
 **/

package coaching.thread;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * a test harness for Java modules.
 **/
public class Application {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    /** The thread map. */
    private final Map<String, AbstractProcess> threadMap = new ConcurrentHashMap<String, AbstractProcess>();

    /**
     * Instantiates a new main application.
     */
    public Application() {
        super();
        initialise();
    }

    /**
     * initialise from configuration file.
     *
     * @return true, if successful, otherwise false., otherwise false.
     */
    public boolean initialise() {
        try {
            final String configFilename = configFilename();

            // * XML file into a DOM
            final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = builderFactory.newDocumentBuilder();
            final Document document = builder.parse(inputStream(configFilename));

            createThreads(document);

        } catch (final Exception exception) {
            LOG.error("{}", exception.toString());
        }

        return false;
    }

    /**
     * Input stream.
     *
     * @param resourceName
     *            the resource name
     * @return the input stream
     */
    protected InputStream inputStream(final String resourceName) {
        final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        final InputStream resourceAsStream = classloader.getResourceAsStream(resourceName);
        return resourceAsStream;
    }

    /**
     * Creates the threads.
     *
     * @param document
     *            the document
     */
    protected void createThreads(final Document document) {
        final Element documentElement = document.getDocumentElement();

        if (documentElement != null) {
            // * threads we must start.
            final NodeList threadListConfig = document.getElementsByTagName("thread");
            for (int i = 0; i < threadListConfig.getLength(); i++) {
                final Element element = (Element) threadListConfig.item(i);

                final String nameAttribute = element.getAttribute("name");
                LOG.info("nameAttribute={}", nameAttribute);

                final String className = element.getAttribute("class");
                LOG.info("className={}", className);

                final AbstractProcess abstractApplicationProcess = createProcess(className);
                if (abstractApplicationProcess != null) {
                    abstractApplicationProcess.start();
                }

                this.threadMap.put(nameAttribute, abstractApplicationProcess);
            }
        }
    }

    /**
     * Creates the process.
     *
     * @param className
     *            the class name
     * @return the abstract process
     */
    protected AbstractProcess createProcess(final String className) {
        try {
            final AbstractProcess process = (AbstractProcess) Class.forName(className).newInstance();
            return process;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            LOG.error("{}", e.toString());
        }
        return null;
    }

    /**
     * Configuration filename.
     *
     * @return the string
     */
    protected String configFilename() {
        final String className = this.getClass().getSimpleName();
        final String configFilename = String.format("%s.xml", className);
        return configFilename;
    }

    /**
     * Foo.
     *
     * @param doc
     *            the doc
     * @return the string
     */
    protected String foo(final Document doc) {
        try {
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            final StreamResult result = new StreamResult(new StringWriter());
            final DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            final String xmlString = result.getWriter().toString();
            return xmlString;
        } catch (IllegalArgumentException | TransformerFactoryConfigurationError | TransformerException e) {
            LOG.error("{}", e.toString());
        }
        return null;
    }

    /**
     * main method.
     *
     * @param args
     *            the arguments as String array.
     */
    public static void main(final String[] args) {
        try {
            new Application();
        } catch (final Exception e) {
            LOG.error("{}", e.toString());
        }
    }
}
