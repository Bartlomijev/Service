package pl.ComputerService.device;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceMapper {


	public DeviceMapper() {

	}

	public List<Device> mapData (ResultSet resultset) {
		int id = 0;
		String deviceName = null;
		boolean repairStatus = false;
		String clientName = null;
		String address = null;
		List<Device> devicesList = new ArrayList<Device>();
		try {
			while (resultset.next()) {

				Device device = new Device(0, null, false, null, null);
				id = resultset.getInt("ID");
				device.setId(id);
				deviceName = resultset.getString("DEVICE_NAME");
				device.setDeviceName(deviceName);
				repairStatus = resultset.getBoolean("REPAIR_STATUS");
				device.setRepairStatus(repairStatus);
				clientName = resultset.getString("CLIENT_NAME");
				device.setClientName(clientName);
				address = resultset.getString("ADDRESS");
				device.setAddress(address);

				devicesList.add(device);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesList;
	}

}