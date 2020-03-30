
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockTest {

	NotesServiceImpl service;
	Mock mock;
	Note object;

	@BeforeEach
	public void setup() {
		mock =  new Mock();
		service = NotesServiceImpl.createWith(mock);
		mock.add(Note.of("Osiem", 5.0f));
		mock.add(Note.of("Osiem", 4.0f));
		mock.add(Note.of("O", 3.0f));
		mock.add(Note.of("O", 4.0f));
		mock.add(Note.of("O", 4.1f));
		mock.add(Note.of("Osiem", 4.1f));
	}

	@AfterEach
	public void cleanup() {
		mock.clear();
	}

	@Test
	public void trivial() {
		assertTrue(true);
	}

	@Test
	public void testGetAllNotesMock() {
		List<Note> grades = mock.getAllNotesOf("Osiem");
		assertEquals(3,grades.size());
	}

	@Test
	public void testAverageGrade() {
		float actual = service.averageOf("O");
		assertEquals(3.7f,actual);
	}

	@Test
	public void testAverageGradeNotExisting() {

		assertThrows(
				IllegalArgumentException.class,
				() -> service.averageOf("Ox")
				);
	}

	@Test
	public void testAverageGradeEmpty() {

		assertThrows(
				IllegalArgumentException.class,
				() -> service.averageOf(""),
				"Imię ucznia nie może być puste"
				);
	}

	@Test
	public void testAverageGradeNull() {

		assertThrows(
				IllegalArgumentException.class,
				() -> service.averageOf(null),
				"Imię ucznia nie może być null"
				);
	}

	@Test
	public void testAdd() {
		service.add(Note.of("Lmao", 3.0f));
		assertEquals(3.0f,mock.getAllNotesOf("Lmao").get(0).getNote());
	}
	
	@Test
	public void testAddTwice() {
		service.add(Note.of("Lmao", 3.0f));
		service.add(Note.of("Lmao", 4.0f));
		assertEquals(4.0f,mock.getAllNotesOf("Lmao").get(1).getNote());
	}

	@Test
	public  void testClear(){
		service.clear();
		assertTrue(mock.grade_map.isEmpty());
	}
	


}


//Należy utworzyć ręcznie atrapę korzstającą z interfejsu NotesStorage.
//Można skorzystać z MultiMap z pakietu Google Guava.
//Nie korzystamy z żadnych narzędzi do tworzenia atrap (np. Mockito czy EasyMock).
//Jako odpowiedź prześlij linki do testów klasy NotesServiceImpl oraz kod klasy NotestStorage w repozytorium.