package pl.ComputerService.device;

public class Device {

	public Device(int deviceId, String name, boolean repairStatus, int clientId, int userId) {
		super();
		
		this.deviceId = deviceId;
		this.name = name;
		this.repairStatus = repairStatus;
		this.clientId = clientId;
		this.userId = userId;
	}

	private int deviceId;
	private String name;
	private boolean repairStatus;
	private int clientId;
	private int userId;
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isRepairStatus() {
		return repairStatus;
	}
	public void setRepairStatus(boolean repairStatus) {
		this.repairStatus = repairStatus;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Device() {
		super();
	}
	
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", name=" + name + ", repairStatus=" + repairStatus + ", clientId="
				+ clientId + ", userId=" + userId + "]";
	}
	
	
}
