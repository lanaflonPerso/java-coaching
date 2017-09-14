/*
 * Template for Dao - Data Access Object
 *
 * Created on 07 September 2004, 10:38
 */

package coaching.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PointBaseCustomerDao Class.
 *
 * @author martin.spamer
 */
public class PointBaseCustomerDao {

	private static final Logger LOG = LoggerFactory.getLogger(PointBaseCustomerDao.class);
	private Connection connection = null;

	public PointBaseCustomerDao() {
		this("", "", "");
	}

	/**
	 * Creates a new instance of DaoTemplate.
	 *
	 * @param connectionUrl the connection url
	 * @param userId the user id
	 * @param password the password
	 */
	public PointBaseCustomerDao(final String connectionUrl, final String userId, final String password) {
		try {
			this.connection = java.sql.DriverManager.getConnection(connectionUrl, userId, password);
		} catch (final java.sql.SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * database SQL> SELECT * from customer_tbl.
	 */
	public void read() {
		try {
			final java.sql.Statement statement = this.connection.createStatement();
			final java.sql.ResultSet resultSet = statement.executeQuery("SELECT * from customers");
			final java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			final int colCount = resultSetMetaData.getColumnCount();

			final StringBuffer output = new StringBuffer();
			while (resultSet.next()) {
				for (int i = 1; i <= colCount; i++) {
					final String columnName = resultSetMetaData.getColumnName(i);
					final Object value = resultSet.getObject(i);
					output.append(columnName + "=");
					if (value != null) {
						output.append(value.toString().trim() + ",");
					}
				}
				output.append("\n");
			}

			LOG.info(output.toString());

			resultSet.close();
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * database. SQL> INSERT INTO CUSTOMER_TBL
	 * (CUSTOMER_NUM,POSTCODE,DISCOUNT_CODE) VALUES (999,'AA99 9ZZ','N')
	 */
	public void write() {
		try {
			final java.sql.Statement statement = this.connection.createStatement();

			final String sql = "INSERT INTO CUSTOMER_TBL (CUSTOMER_NUM, POSTCODE,DISCOUNT_CODE) VALUES (999,'AA99 9ZZ','N')";
			final int result = statement.executeUpdate(sql);

			LOG.info("Rows updated: " + result + " for " + sql);
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * database. SQL> UPDATE CUSTOMER_TBL SET NAME
	 * ='DataMentor' WHERE CUSTOMER_NUM=999
	 */
	public void update() {
		try {
			final java.sql.Statement statement = this.connection.createStatement();

			final String sql = "UPDATE CUSTOMER_TBL SET NAME ='DataMentor' WHERE CUSTOMER_NUM=999";
			final int result = statement.executeUpdate(sql);

			LOG.info("Rows updated: " + result + " for " + sql);
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * database. SQL> DELETE FROM CUSTOMER_TBL WHERE
	 * FIELD-NAME='VALUE'
	 */
	public void delete() {
		try {
			final java.sql.Statement statement = this.connection.createStatement();

			final String sql = "DELETE FROM CUSTOMER_TBL WHERE CUSTOMER_NUM=999";
			final int result = statement.executeUpdate(sql);

			LOG.info("Rows updated: " + result + " for " + sql);
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
	}

	/** * DB connection. */
	@Override
	public void finalize() {
		try {
			this.connection.close();
		} catch (final java.sql.SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * main method.
	 *
	 * command line arguments
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final String connectionUrl = "jdbc:pointbase://localhost:9092/sample";
		final String userId = "PBPUBLIC";
		final String password = "PBPUBLIC";

		try {
			Class.forName("com.pointbase.jdbc.jdbcUniversalDriver");

			try {
				final PointBaseCustomerDao dao = new PointBaseCustomerDao(connectionUrl, userId, password);
				dao.read();
				dao.write();
				dao.update();
				dao.delete();
			} catch (final Exception exception) {
				exception.printStackTrace();
			}
		} catch (final Exception exception) {
			exception.printStackTrace();
		}
	}
}
