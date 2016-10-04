package pl.ComputerService.client;

public class TestingClass {

	public static void main(String[] args) {

		JdbcConnector c = new JdbcConnector();
		c.initConnection();
		QueryExecutor executor = new QueryExecutor(c.getConn());
		ClientMapper qm = new ClientMapper();
		ClientDAO dao = new ClientDAO(executor, qm);

		System.out.println(dao.getAllClients());
		System.out.println("******");
		
		
		c.closeConnection();

	}
}
