import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.startsWith;


public class NoteTest {
	
	Note note;
		
//	public static Note of(final String name, final float note);
//	public String getName();
//	public float getNote();

    @Test 
    void trivialtest() {
        assertTrue(true);
    }
    
    //Exception dla ocena 1<x<6,  imie puste, imie null
    @ParameterizedTest(name = "Test {index} : uczeń {0} z ocena {1} ma zwracać {2}")
    @CsvSource({ 
    	"'jeden',1.0f,'Niewłaściwa ocena'", 
    	",1.0f,'Imię ucznia nie może być null'",
    	"'',1.0f,'Imię ucznia nie może być puste'" })
    void ExceptionsTest(String name, float grade, String expected) {
    	assertThrows(
				IllegalArgumentException.class,
				() -> Note.of(name, grade),
				expected
				);
    }
    
    @ParameterizedTest(name = "Powinno być true gdy funkcja zwróci {0}")
    @CsvSource({ 
    	"'Zbyszek',3.0f", 
    	"'Rysiek',4.5f",
    	"'Antoni',5.0f" })
    void getNameTest(String name, float grade) {
    	note = Note.of(name, grade);
    	assertEquals(name,note.getName());
    }
    
    @ParameterizedTest(name = "Powinno być true gdy funkcja zwróci {1}")
    @CsvSource({ 
    	"'Antek', 3.0f", 
    	"'Jarek', 4.5f",
    	"'Zbyszek', 6.0f" })
    void getNoteTest(String name, float grade) {
    	note = Note.of(name, grade);
    	assertEquals(grade,note.getNote());
    }
    
}


