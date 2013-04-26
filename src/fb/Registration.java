package fb;

import java.util.HashMap;

public class Registration {
	
	private ExternalRegistrator registration;
	private Model users;

	public void register(String userId){
		HashMap<Integer,Integer> userData = registration.getUserData();
		if(!userData.isEmpty())
			users.create(userData);
	}

	public void setRegistrator(ExternalRegistrator registrator){
		registration = registrator;
		
	}
	
	public void setUsers(Model users){
		this.users = users;
		
	}
}


