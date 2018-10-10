
package coaching.jdbc;

import java.util.List;

import coaching.csv.CsvRecord;

/**
 * A Data Access Object for a Sqlite3 database.
 */
public final class SqLiteDao extends AbstractDao {

    /** The classname of the JDBC driver to use. */
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";

    /** The URL to use to make JDBC connection. */
    public static final String JDBC_URL = "jdbc:sqlite:sample.db";

    /** USERNAME. */
    public static final String USERNAME = "username";

    /** PASSWORD. */
    private static final String PASSWORD = "password";

    /**
     * Instantiates a new my SQL DAO.
     *
     * @throws ClassNotFoundException the class not found exception
     */
    public SqLiteDao() throws ClassNotFoundException {
        super(JDBC_DRIVER, JDBC_URL, USERNAME, PASSWORD);
    }

    /**
     * Insert rows.
     *
     * @param rowList the row list
     */
    public void insertRows(final List<CsvRecord> rowList) {
    }

}
