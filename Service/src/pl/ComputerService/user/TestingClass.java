package pl.ComputerService.user;

public class TestingClass {

	public static void main(String[] args) {

		JdbcConnector c = new JdbcConnector();
		c.initConnection();
		QueryExecutor executor = new QueryExecutor(c.getConn());
		UserMapper qm = new UserMapper();
		UserDAO dao = new UserDAO(executor, qm);

		System.out.println(dao.getAllUsers());
		System.out.println("******");
	
		
		c.closeConnection();

	}
}
