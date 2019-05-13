package dataAccess.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/furniture_deals";
	private static final String USER = "root";
	private static final String PASS = "roxana18";

	private static ConnectionFactory singleInstance;

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		if(singleInstance==null) {
			singleInstance=new ConnectionFactory();
		}
		return singleInstance;
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(DBURL, USER, PASS);
			//System.out.println(connection);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection() {
		return singleInstance.createConnection();
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}
}


