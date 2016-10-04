package pl.ComputerService.client;

public class Client {

	private int clientId;
	public Client(int clientId, String clientName, String clientAddress, int userId) {
		super(); 
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.userId = userId;
	}

	private String clientName;
	private String clientAddress;
	private int userId;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Client() {
		super();
	}
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientAddress=" + clientAddress
				+ ", userId=" + userId + "]";
	}
	
	
	
}
