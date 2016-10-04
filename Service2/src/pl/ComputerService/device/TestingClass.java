package pl.ComputerService.device;

public class TestingClass {

	public static void main(String[] args) {

		JdbcConnector c = new JdbcConnector();
		c.initConnection();
		QueryExecutor executor = new QueryExecutor(c.getConn());
		DeviceMapper qm = new DeviceMapper();
		DeviceDAO dao = new DeviceDAO(executor, qm);

		System.out.println(dao.getAllDevices());
		System.out.println("******");
		System.out.println(dao.getUnrepairedDevices());
		System.out.println("}}}}}}}");
		System.out.println(dao.getRepairedDevices());
		System.out.println("-----");
		
		c.closeConnection();

	}
}
