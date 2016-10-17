package pl.ComputerService.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import pl.ComputerService.data.Device;
import pl.ComputerService.provider.ConnectionProvider;
 
public class DeviceDAO {
 
	final String SEARCH = "SELECT DEVICE_ID, DEVICE_NAME, PROBLEM_DESCRIPTION, REPAIR_STATUS FROM device WHERE DEVICE_ID = ?;";
	final String CREATE = "INSERT INTO device(DEVICE_ID, DEVICE_NAME, PROBLEM_DESCRIPTION, REPAIR_STATUS) VALUES(?, ?, ?, ?);";
	final String UPDATE = "UPDATE device SET REPAIR_STATUS = ? WHERE DEVICE_ID = ?;";
	final String DELETE = "DELETE FROM device WHERE DEVICE_ID = ?;";
 
    public boolean create(Device device) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(CREATE);
            prepStmt.setInt(1, device.getDeviceId());
            prepStmt.setString(2, device.getDeviceName());
            prepStmt.setString(3, device.getDeviceDescription());
            prepStmt.setString(4, device.getDeviceRepairStatus());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }
 
    public Device read(int id) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        Device resultdevice = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(SEARCH);
            prepStmt.setInt(1, id);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()) {
                resultdevice = new Device(); 
                resultdevice.setDeviceId(resultSet.getInt("DEVICE_ID"));
                resultdevice.setDeviceName(resultSet.getString("DEVICE_NAME"));
                resultdevice.setDeviceDescription(resultSet.getString("PROBLEM_DESCRIPTION"));
                resultdevice.setDeviceRepairStatus(resultSet.getString("REPAIR_STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return resultdevice;
    }
 
    public boolean update(Device device) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(UPDATE);
            prepStmt.setString(1, device.getDeviceRepairStatus());
            prepStmt.setInt(2, device.getDeviceId());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }
 
    public boolean delete(Device device) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DELETE);
            prepStmt.setInt(1, device.getDeviceId());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }
 
    private void releaseResources(PreparedStatement prepStmt, ResultSet res,
            Connection conn) {
        try {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (res != null && !res.isClosed()) {
                res.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
}