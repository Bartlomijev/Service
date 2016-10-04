package pl.ComputerService.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnector {

	private final String URL = "localhost";
	private final String PORT = "3306";
	private final String DATABASE_NAME = "service";
	private Connection conn;


	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public JdbcConnector() {

	}

	public Connection initConnection() {
		Connection conn = null;
		final String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("driver is not found");
			e.printStackTrace();
		}
		final String dbPath = "jdbc:mysql://" + URL + ":" + PORT + "/" + DATABASE_NAME + "?useSSL=false";
		try {
			conn = (DriverManager.getConnection(dbPath, "root", "root"));
			this.conn = conn;
		} catch (SQLException e) {
			System.out.println("connection data is not correct");
			e.printStackTrace();
		}
		return conn;

	}

	public void closeConnection(){
		QueryExecutor qe = new QueryExecutor(conn);
		 if(qe.getStatement() != null) {
			 try {
				qe.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        }
	        if(qe.getResultSet() != null) {
	        	try {
					qe.getResultSet().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
	        if(conn != null) {
	            try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
	}

}
