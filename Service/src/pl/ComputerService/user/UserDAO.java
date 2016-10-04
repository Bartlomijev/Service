package pl.ComputerService.user;


import java.util.List;

public class UserDAO {

	final String query = "SELECT EMAIL, PASSWORD, USER_ID, USER_NAME FROM User";
	private List<User> UsersList;


	public List<User> initMapping(QueryExecutor que, UserMapper map){
		return map.mapData(que.execute(query));
	}

	public UserDAO(QueryExecutor que, UserMapper map) {

		UsersList = initMapping(que, map);

	}

	public List<User> getAllUsers() {
		return UsersList;

	}

	
	

	
}
