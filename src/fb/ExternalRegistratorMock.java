package fb;

import java.util.HashMap;

public class ExternalRegistratorMock implements ExternalRegistrator {

	private int calls = 0;

	@Override
	public HashMap<Integer,Integer> getUserData() {
		calls++;
		return new HashMap<Integer,Integer>();
	}

	public boolean wasGetUserDataCalled() {
		return calls  > 0;
		
	}

}
