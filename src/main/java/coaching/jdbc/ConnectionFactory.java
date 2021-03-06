
package coaching.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * A factory for creating Connection objects.
 */
public final class ConnectionFactory implements ConnectionFactoryInterface {

    /** The log. */
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The jdbc url. */
    private String jdbcUrl;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /**
     * Private constructor prevents wild instantiations.
     */
    public ConnectionFactory() {
        super();
        try {
            Class.forName(JdbcConfig.driver());
            this.jdbcUrl = JdbcConfig.url();
            this.username = JdbcConfig.username();
            this.password = JdbcConfig.password();
        } catch (final ClassNotFoundException e) {
            this.log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * Instantiates a new connection factory.
     *
     * @param jdbcDriver the jdbc driver
     * @param jdbcUrl the jdbc url
     * @param username the username
     * @param password the password
     */
    public ConnectionFactory(final String jdbcDriver, final String jdbcUrl, final String username, final String password) {
        super();
        try {
            Class.forName(jdbcDriver);
            this.jdbcUrl = jdbcUrl;
            this.username = username;
            this.password = password;
        } catch (final ClassNotFoundException e) {
            this.log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     * @throws SQLException the SQL exception
     */
    public static Connection getConnection() throws SQLException {
        return new ConnectionFactory().newConnection();
    }

    /*
     * (non-Javadoc)
     * @see coaching.jdbc.ConnectionFactoryInterface#newConnection()
     */
    @Override
    public Connection newConnection() throws SQLException {
        assertNotNull(this.jdbcUrl);
        assertNotNull(this.username);
        assertNotNull(this.password);

        return DriverManager.getConnection(this.jdbcUrl, this.username, this.password);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [JdbcConfig=%s]", this.getClass().getSimpleName(), JdbcConfig.getInstance().toString());
    }

}
