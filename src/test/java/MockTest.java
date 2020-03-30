
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
		service.add(Note.of("test",2.0f));
		
		assertEquals(2.0f,storage.getAllNotesOf("test").get(0));
	}

	


}


//Należy utworzyć ręcznie atrapę korzstającą z interfejsu NotesStorage.
//Można skorzystać z MultiMap z pakietu Google Guava.
//Nie korzystamy z żadnych narzędzi do tworzenia atrap (np. Mockito czy EasyMock).
//Jako odpowiedź prześlij linki do testów klasy NotesServiceImpl oraz kod klasy NotestStorage w repozytorium.