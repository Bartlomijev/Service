package pl.ComputerService.device;

import java.util.ArrayList;
import java.util.List;

public class DeviceDAO {

	final String query = "SELECT ADDRESS, CLIENT_NAME, DEVICE_NAME, ID, REPAIR_STATUS FROM device";
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
