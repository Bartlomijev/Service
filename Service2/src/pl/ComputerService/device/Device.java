package pl.ComputerService.device;

public class Device {

	
	private int id;
	private String deviceName;
	private boolean repairStatus;
	private String clientName;
	private String address;
	
	public Device(int id, String deviceName, boolean repairStatus, String clientName, String address) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.repairStatus = repairStatus;
		this.clientName = clientName;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public boolean isRepairStatus() {
		return repairStatus;
	}
	public void setRepairStatus(boolean repairStatus) {
		this.repairStatus = repairStatus;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Device [id=" + id + ", deviceName=" + deviceName + ", repairStatus=" + repairStatus + ", clientName="
				+ clientName + ", address=" + address + "]";
	}

}
	