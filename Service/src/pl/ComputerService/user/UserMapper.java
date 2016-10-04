package pl.ComputerService.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {


	public UserMapper() {

	}

	public List<User> mapData (ResultSet resultset) {
		int userId = 0;
		String userName = null;
		String password = null;
		String email = null;
		
		List<User> usersList = new ArrayList<User>();
		try {
			while (resultset.next()) {

				User user = new User(0, null, null, null);
				userId = resultset.getInt("USER_ID");
				user.setUserId(userId);
				userName = resultset.getString("USER_NAME");
				user.setUserName(userName);
				password = resultset.getString("PASSWORD");
				user.setPassword(password);
				email = resultset.getString("EMAIL");
				user.setEmail(email);
			

				usersList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

}