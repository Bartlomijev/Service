package pl.ComputerService.device;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {

	JdbcConnector c = new JdbcConnector();

	private ResultSet resultSet;
	private Statement statement;
	private Connection connection;

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}



	public QueryExecutor(String stmt) {

	}

	public QueryExecutor(Connection conn) {
		c.setConn(conn);
		setConnection(conn);
	}

	public ResultSet execute(String stmt) {

		ResultSet resultSet = null;
		Statement statement = null;

		try {
			statement = c.getConn().createStatement();
			resultSet = statement.executeQuery(stmt);
			setStatement(statement);
			setResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
