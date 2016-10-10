package pl.ComputerService.Servlet;


 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import pl.ComputerService.dao.DeviceDAO;
import pl.ComputerService.data.Device;
 

public class DeviceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
    	String deviceName = request.getParameter("deviceName");
    	boolean repairStatus = Boolean.parseBoolean(request.getParameter("repairStatus"));
    	String clientName = request.getParameter("clientName");
    	String address = request.getParameter("address");
        String option = request.getParameter("option");
        DeviceDAO dao = new DeviceDAO();
        Device device = null;
        String operation = null;
        boolean result = false;
        if("search".equals(option)) {
            device = dao.read(id);
            result = device!=null? true:false;
            operation = "search";
        } else if("add".equals(option)) {
            device = new Device(id, deviceName, repairStatus, clientName, address);
            result = dao.create(device);
            operation = "add";
        } else if("update".equals(option)) {
            device = new Device(id, deviceName, repairStatus, clientName, address);
            result = dao.update(device);
            operation = "update";
        } else if("delete".equals(option)) {        	
            device = new Device(id, deviceName, repairStatus, clientName, address);
            result = dao.delete(device);
            operation = "delete";
        }
        if(device != null && result) {
            request.setAttribute("option", operation);
            request.setAttribute("device", device);          
            request.getRequestDispatcher("tableView.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
 
}