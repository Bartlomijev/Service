package pl.ComputerService.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import pl.ComputerService.data.Device;
import pl.ComputerService.provider.ConnectionProvider;
 
public class DeviceDAO {
 
	final String READ = "SELECT ADDRESS, CLIENT_NAME, DEVICE_NAME, ID, REPAIR_STATUS FROM device WHERE ID = ?;";
	final String CREATE = "INSERT INTO device(ID, ADDRESS, CLIENT_NAME, DEVICE_NAME, REPAIR_STATUS) VALUES(?, ?, ?, ?, ?);";
	final String UPDATE = "UPDATE device SET REPAIR_STATUS = ? WHERE ID = ?;";
	final String DELETE = "DELETE FROM device WHERE ID = ?;";
 
    public boolean create(Device device) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(CREATE);
            prepStmt.setInt(1, device.getId());
            prepStmt.setString(2, device.getAddress());
            prepStmt.setString(3, device.getClientName());
            prepStmt.setString(4, device.getDeviceName());
            prepStmt.setBoolean(5, device.isRepairStatus());
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
            prepStmt = conn.prepareStatement(READ);
            prepStmt.setInt(1, id);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()) {
                resultdevice = new Device(); 
                resultdevice.setId(resultSet.getInt("ID"));
                resultdevice.setAddress(resultSet.getString("ADDRESS"));
                resultdevice.setClientName(resultSet.getString("CLIENT_NAME"));
                resultdevice.setDeviceName(resultSet.getString("DEVICE_NAME"));
                resultdevice.setRepairStatus(resultSet.getBoolean("REPAIR_STATUS"));
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
            prepStmt.setBoolean(1, device.isRepairStatus());
            prepStmt.setInt(2, device.getId());
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
            prepStmt.setInt(1, device.getId());
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