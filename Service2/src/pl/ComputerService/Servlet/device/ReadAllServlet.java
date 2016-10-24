package pl.ComputerService.Servlet.device;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.jdbc.dao.DeviceDAO;
import pl.ComputerService.jdbc.data.Device;


public class ReadAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        DeviceDAO dao = new DeviceDAO();
        List<Device> allDevicesList = new ArrayList<>(); 
        String operation;
        boolean result = false;
       
        allDevicesList = dao.readAll();
            result = allDevicesList!=null? true:false;
            operation = "readAll";
        
        
        if(allDevicesList != null && result) {
            request.setAttribute("option", operation);
            request.setAttribute("list", allDevicesList);          
            request.getRequestDispatcher("tableView.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}
}