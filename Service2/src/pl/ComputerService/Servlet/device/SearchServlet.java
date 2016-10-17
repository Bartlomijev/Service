package pl.ComputerService.Servlet.device;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.dao.DeviceDAO;
import pl.ComputerService.data.Device;



public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("deviceId"));
        //String deviceRepairStatus = request.getParameter("")
        DeviceDAO dao = new DeviceDAO();
        Device device = null;
        String operation = null;
        boolean result = false;
       
            device = dao.read(id);
            result = device!=null? true:false;
            operation = "search";
        
        
        if(device != null && result) {
            request.setAttribute("option", operation);
            request.setAttribute("device", device);          
            request.getRequestDispatcher("tableView.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}
}
