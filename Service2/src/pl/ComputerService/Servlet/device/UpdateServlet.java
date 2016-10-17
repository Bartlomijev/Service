package pl.ComputerService.Servlet.device;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.dao.DeviceDAO;
import pl.ComputerService.data.Device;



public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
    	String deviceName = null;
    	String deviceDescription = null;
    	String deviceRepairStatus = request.getParameter("deviceRepairStatus");
        DeviceDAO dao = new DeviceDAO();
        Device device = null;
        String operation = null;
        boolean result = false;
        
      
            device = new Device(deviceId, deviceName, deviceDescription, deviceRepairStatus);
            result = dao.update(device);
            operation = "update";
        
        if(device != null && result) {
            request.setAttribute("option", operation);
            request.setAttribute("device", device);          
            request.getRequestDispatcher("tableView.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}

}
