package pl.ComputerService.device;

import java.util.ArrayList;
import java.util.List;

public class DeviceDAO {

	final String query = "SELECT client_CLIENT_ID, DEVICE_ID, NAME, REPAIR_STATUS, user_USER_ID FROM Device";
	private List<Device> devicesList;


	public List<Device> initMapping(QueryExecutor que, DeviceMapper map){
		return map.mapData(que.execute(query));
	}

	public DeviceDAO(QueryExecutor que, DeviceMapper map) {

		devicesList = initMapping(que, map);

	}

	public List<Device> getAllDevices() {
		return devicesList;

	}

	
	public List<Device> getUnrepairedDevices() {
		List<Device>DevicesSet = new ArrayList<Device>();

		for (Device q : devicesList) {
			if (q.isRepairStatus() == false) {
				DevicesSet.add(q);
			}
		}
		return DevicesSet;

	}

	public List<Device> getRepairedDevices() {
		List<Device>DevicesSet = new ArrayList<Device>();

		for (Device q : devicesList) {
			if (q.isRepairStatus() == true) {
				DevicesSet.add(q);
			}
		}
		return DevicesSet;

	}
}
