package pl.ComputerService.client;

import java.util.List;

public class ClientDAO {

	final String query = "SELECT CLIENT_ADDRESS, CLIENT_ID, CLIENT_NAME, user_USER_ID FROM Client";
	private List<Client> ClientsList;


	public List<Client> initMapping(QueryExecutor que, ClientMapper map){
		return map.mapData(que.execute(query));
	}

	public ClientDAO(QueryExecutor que, ClientMapper map) {

		ClientsList = initMapping(que, map);

	}

	public List<Client> getAllClients() {
		return ClientsList;

	}

	

}
