package pl.ComputerService.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.device.DeviceDAO;
import pl.ComputerService.device.DeviceMapper;
import pl.ComputerService.device.JdbcConnector;
import pl.ComputerService.device.QueryExecutor;

import pl.ComputerService.device.*;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("¿¹danie get przetworzono!");
		String param = request.getParameter("get");
		// wyœwietlanie produktów
		if ("show".equals(param)) {
			System.out.println("show");
			List<Device> devicesTable = getDevices();
			request.setAttribute("devicesTable", devicesTable);
			request.getRequestDispatcher("tableView.jsp").forward(request, response);
		}
		else if ("add".equals(param)) {
			System.out.println("add");
			request.getRequestDispatcher("addForm.jsp").forward(request, response);
		}
		else if ("remove".equals(param)) {
			System.out.println("remove");
			request.getRequestDispatcher("removeForm.jsp").forward(request, response);
		}
		
		else if ("update".equals(param)) {
			System.out.println("update");
			request.getRequestDispatcher("updateForm.jsp").forward(request, response);
		} else {
			response.sendError(403);
		}
	}

	private List<Device> getDevices() {
		JdbcConnector c = new JdbcConnector();
		c.initConnection();
		QueryExecutor executor = new QueryExecutor(c.getConn());
		DeviceMapper qm = new DeviceMapper();
		DeviceDAO dao = new DeviceDAO(executor, qm);
		return dao.getAllDevices();
	}
}
