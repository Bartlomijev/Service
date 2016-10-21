package pl.ComputerService.Servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.ComputerService.jdbc.data.User;
import pl.ComputerService.jdbc.data.UserRoleName;

public class AuthorisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		User user;
		user = (User) request.getAttribute("user");
		

		if (UserRoleName.CLIENT.getRoleDescription().equals(user.getUserRoleName())) {
			request.getRequestDispatcher("clientIndex.jsp").forward(request, response);
		} else if (UserRoleName.SERVICEMAN.getRoleDescription().equals(user.getUserRoleName())) {
			request.getRequestDispatcher("servicemanIndex.jsp").forward(request, response);
		} else if (UserRoleName.MANAGER.getRoleDescription().equals(user.getUserRoleName())) {
			request.getRequestDispatcher("managerIndex.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
