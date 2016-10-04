package pl.ComputerService.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {


	public ClientMapper() {

	}

	public List<Client> mapData (ResultSet resultset) {
		int clientId;
		String clientName;
		String clientAddress;
		int userId;
		List<Client> clientsList = new ArrayList<Client>();
		try {
			while (resultset.next()) {

				Client client = new Client(0, null, null, 0);
				clientId = resultset.getInt("CLIENT_ID");
				client.setClientId(clientId);
				clientName = resultset.getString("CLIENT_NAME");
				client.setClientName(clientName);;
				clientAddress = resultset.getString("CLIENT_ADDRESS");
				client.setClientAddress(clientAddress);
				userId = resultset.getInt("user_USER_ID");
				client.setUserId(userId);
				

				clientsList.add(client);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsList;
	}

}