
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockTest {
	
	NotesServiceImpl service;
	NotesStorage storage;
	
	@BeforeEach
	public void setUp() {
		service = NotesServiceImpl.createWith(storage);
	}

	@Test
	public void testQuittingTime() {
		service.add(Note.of("test",1.0f));
		
		assertFalse(env.wavWasPlayed());
	}
	
	@Test
	public void testSetUpTo17() {
		t1 += (5*60*1000);
		env.setTime(t1);
		checker.remainder();
		assertTrue(env.wavWasPlayed());
	}
	
	@Test
	public void testSetUpTo18_55() {
		t1 += 2*60*60*1000;
		env.setTime(t1);
		checker.remainder();
		assertTrue(env.wavWasPlayed());
	}
	
	@AfterEach
	public void tearDown() {
		env.resetWav();
	}

}


//Należy utworzyć ręcznie atrapę korzstającą z interfejsu NotesStorage.
//Można skorzystać z MultiMap z pakietu Google Guava.
//Nie korzystamy z żadnych narzędzi do tworzenia atrap (np. Mockito czy EasyMock).
//Jako odpowiedź prześlij linki do testów klasy NotesServiceImpl oraz kod klasy NotestStorage w repozytorium.