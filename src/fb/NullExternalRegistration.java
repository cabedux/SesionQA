package fb;

import java.util.HashMap;

public class NullExternalRegistration implements ExternalRegistrator {

	@Override
	public HashMap<Integer,Integer> getUserData() {
		return new HashMap<Integer,Integer>();
	}

}
