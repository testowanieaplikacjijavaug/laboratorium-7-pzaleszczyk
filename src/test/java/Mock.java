import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;



public class Mock implements NotesStorage{

    public ListMultimap<String, List<Note>> grade_map = ArrayListMultimap.create();

    
	@Override
	public void add(Note note) {
		
		List<Note> grades;
		
		if( grade_map.containsKey( note.getName() ) ) 
		{
			grades = grade_map.get(note.getName()).get(0);
			grades.add(note);	
		}
        else
        {
            grades = new ArrayList<Note>();
            grades.add(note);
            grade_map.put(note.getName(), grades);
        }
		
	}

	@Override
	public List<Note> getAllNotesOf(String name) {
		if(!grade_map.containsKey(name))
			throw new IllegalArgumentException();
		List<Note> grades =  grade_map.get(name).get(0);
		return grades;
	}

	@Override
	public void clear() {
		grade_map.clear();
	}

}
