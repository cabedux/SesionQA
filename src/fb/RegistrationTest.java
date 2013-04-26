package fb;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import static org.mockito.Mockito.*; 
 

public class RegistrationTest {

	@Test
	public void registerCallsExternalRegistration() {
		Registration registration = new Registration();
		
		//ExternalRegistratorMock externalRegistrationMock = new ExternalRegistratorMock();
		ExternalRegistrator externalRegistrationMock = mock(ExternalRegistrator.class);
		//Model usersStub = new ModelStub();
		Model usersStub = mock(Model.class);
		registration.setUsers(usersStub);
		registration.setRegistrator(externalRegistrationMock);
		
		registration.register("123");
		
		//assertTrue(externalRegistrationMock.wasGetUserDataCalled());
		verify(externalRegistrationMock).getUserData();
	}

	@Test
	public void registerCallsUsersCreation() {
		Registration registration = new Registration();
		//ModelMock modelMock = new ModelMock();
		Model modelMock = mock(Model.class);
		//ExternalRegistrationStub externalRegistrationStub = new ExternalRegistrationStub();
		ExternalRegistrator externalRegistrationStub = mock(ExternalRegistrator.class);
		registration.setUsers(modelMock);
		registration.setRegistrator(externalRegistrationStub);
		HashMap<Integer,Integer> hm  = new HashMap<Integer,Integer>();
		hm.put(1, 1);
		when(externalRegistrationStub.getUserData()).thenReturn(hm);
		
		registration.register("123");
		
		//assertTrue(modelMock.wasCreateCalled());
		verify(modelMock).create(hm);
	}
	
	@Test
	public void registerDoesNotCallCreateWhenUsersDataIsEmpty() {
		Registration registration = new Registration();
		//ModelMock modelMock = new ModelMock();
		Model modelMock = mock(Model.class);
		//NullExternalRegistration externalRegistrationStub = new NullExternalRegistration();
		ExternalRegistrator externalRegistrationStub = mock(ExternalRegistrator.class);
		when(externalRegistrationStub.getUserData()).thenReturn(new HashMap<Integer,Integer>());
		registration.setUsers(modelMock);
		registration.setRegistrator(externalRegistrationStub);
		HashMap<Integer, Integer> notUsedHash = new HashMap<Integer, Integer>()
		
		registration.register("123");
		
		//assertFalse(modelMock.wasCreateCalled());
		verify(modelMock, never()).create(notUsedHash);
	}
}


