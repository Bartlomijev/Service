package pl.ComputerService.device;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceMapper {


	public DeviceMapper() {

	}

	public List<Device> mapData (ResultSet resultset) {
		int deviceId = 0;
		String name = null;
		boolean repairStatus = false;
		int clientId = 0;
		int userId = 0;
		List<Device> devicesList = new ArrayList<Device>();
		try {
			while (resultset.next()) {

				Device device = new Device(0, null, false, 0, 0);
				deviceId = resultset.getInt("DEVICE_ID");
				device.setDeviceId(deviceId);
				name = resultset.getString("NAME");
				device.setName(name);
				repairStatus = resultset.getBoolean("REPAIR_STATUS");
				device.setRepairStatus(repairStatus);
				clientId = resultset.getInt("client_CLIENT_ID");
				device.setClientId(clientId);
				userId = resultset.getInt("user_USER_ID");
				device.setUserId(userId);

				devicesList.add(device);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesList;
	}

}