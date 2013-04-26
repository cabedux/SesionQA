package fb;

import java.util.HashMap;

public class ExternalRegistrationStub implements ExternalRegistrator {

	@Override
	public HashMap<Integer,Integer> getUserData() {
		HashMap<Integer,Integer> hm  = new HashMap<Integer,Integer>();
		hm.put(1, 1);
		return hm;
	}
	
}
