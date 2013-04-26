package fb;

import java.util.HashMap;

public class ModelMock implements Model {

	private int calls = 0;

	@Override
	public void create(HashMap<Integer,Integer> userData) {
		calls++;
	}

	public boolean wasCreateCalled() {
		return calls  > 0;
	}

}
