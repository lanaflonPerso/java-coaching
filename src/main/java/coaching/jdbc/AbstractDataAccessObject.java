
package coaching.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Data Access object.
 *
 * Uses domain language to provide Create Read Update Delete interface.
 */
public abstract class AbstractDataAccessObject implements DaoInterface {

    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    protected ConnectionFactory connectionFactory;
    protected ResultSet resultSet;
    protected ResultSetMetaData resultSetMetaData;

    private String driver;
    private String url;
    private String username;
    private String password;

    public AbstractDataAccessObject() {
    }

    /**
     * Creates a new instance of DaoTemplate.
     *
     * @param driverClassName
     *            the driver class name
     */
    public AbstractDataAccessObject(final String driverClassName) {
        try {
            Class.forName(driverClassName);
        } catch (final ClassNotFoundException e) {
            this.log.error(e.toString());
        }
    }

    /**
     * Creates a new instance of DaoTemplate.
     *
     * @param driverClassName
     *            the driver class name
     * @param connectionUrl
     *            the connection url
     * @param username
     *            the username
     * @param password
     *            the password
     */
    public AbstractDataAccessObject(final String driverClassName,
            final String connectionUrl,
            final String username,
            final String password) {
        this(driverClassName);
        this.connectionFactory = new ConnectionFactory(driverClassName, connectionUrl, username, password);
    }

    /*
     * (non-Javadoc)
     *
     * @see coaching.jdbc.DaoInterface#setDriver(java.lang.String)
     */
    @Override
    public DaoInterface setDriver(final String driverClassName) {
        this.driver = driverClassName;
        try {
            Class.forName(driverClassName);
        } catch (final ClassNotFoundException e) {
            this.log.error(e.toString());
        }

        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see coaching.jdbc.DaoInterface#setUrl(java.lang.String)
     */
    @Override
    public DaoInterface setUrl(final String url) {
        this.url = url;
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see coaching.jdbc.DaoInterface#setUsername(java.lang.String)
     */
    @Override
    public DaoInterface setUsername(final String username) {
        this.username = username;
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see coaching.jdbc.DaoInterface#setPassword(java.lang.String)
     */
    @Override
    public DaoInterface setPassword(final String password) {
        this.password = password;
        return this;
    }

    /**
     * Execute a SQL insert statement for CRUD interface. <code>
     * 	INSERT INTO CUSTOMER_TBL
     * 		(CUSTOMER_NUM,POSTCODE,DISCOUNT_CODE)
     * 	VALUES
     * 		(999,'AA99 9ZZ','N')
     * </code>.
     *
     * @param sql
     *            the sql
     * @return this as fluent interface.
     */
    @Override
    public DaoInterface create(final String sql) {
        return sql(sql);
    }

    /**
     * Execute a SQL select statement for CRUD interface. <code>
     * 	SELECT * from customer table.
     * </code>
     *
     * @param sql
     *            the sql
     * @return this as fluent interface.
     */
    @Override
    public DaoInterface read(final String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = this.connectionFactory.getConnection();
            statement = connection.createStatement();
            this.resultSet = statement.executeQuery(sql);

            handleResultSet(this.resultSet);

            this.resultSet.close();
            statement.close();
            connection.close();
        } catch (final SQLException exception) {
            this.log.error(exception.toString());
        } finally {
            try {
                if (this.resultSet != null) {
                    this.resultSet.close();
                }
            } catch (final Exception e) {
                this.log.error(e.getLocalizedMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (final Exception e) {
                this.log.error(e.getLocalizedMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (final Exception e) {
                this.log.error(e.getLocalizedMessage());
            }
        }
        return this;
    }

    /**
     * Handle result set.
     *
     * @param resultSet
     *            the result set
     * @throws SQLException
     *             the SQL exception
     */
    protected void handleResultSet(final ResultSet resultSet) throws SQLException {
        final StringBuilder output = new StringBuilder();
        while (resultSet.next()) {
            output.append(processRow(resultSet));
            output.append('\n');
        }
        this.log.info(output.toString());
    }

    /**
     * Process row.
     *
     * @param resultSet
     *            the result set
     * @return the string
     * @throws SQLException
     *             the SQL exception
     */
    protected String processRow(final ResultSet resultSet) throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        final int colCount = metaData.getColumnCount();
        final StringBuffer output = new StringBuffer();
        for (int i = 1; i <= colCount; i++) {
            final String columnName = metaData.getColumnName(i);
            final Object value = resultSet.getObject(i);
            if (value == null) {
                output.append(String.format("%s = %s,", columnName, value.toString().trim()));
            } else {
                output.append(String.format("%s = null,", columnName));
            }
        }
        return output.toString();
    }

    /**
     * Execute a SQL update statement for CRUD interface. <code>
     * 	UPDATE
     * 		CUSTOMER_TBL
     * 	SET
     * 		NAME ='DataMentor'
     * 	WHERE
     * 		CUSTOMER_NUM=999
     * </code>.
     *
     * @param sql
     *            the sql
     * @return this as fluent interface.
     */
    @Override
    public DaoInterface update(final String sql) {
        return sql(sql);
    }

    /**
     * Execute a SQL delete statement for CRUD interface. <code>
     * 	DELETE FROM
     * 		CUSTOMER_TBL
     * 	WHERE
     * 		FIELD-NAME='VALUE'
     * </code>.
     *
     * @param sql
     *            the sql
     * @return this as fluent interface.
     */
    @Override
    public DaoInterface delete(final String sql) {
        return sql(sql);
    }

    /**
     * execute an sql statement.
     *
     * @param sql
     *            the sql
     * @return the dao interface
     */
    public DaoInterface sql(final String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            final int result = preparedStatement.executeUpdate();
            this.log.info("Rows updated: {}", result);
            preparedStatement.close();
            connection.close();
        } catch (final SQLException exception) {
            this.log.error(exception.toString());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (final SQLException e) {
                this.log.error(e.getLocalizedMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (final SQLException e) {
                this.log.error(e.getLocalizedMessage());
            }
        }
        return this;
    }
}
