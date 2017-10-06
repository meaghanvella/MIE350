import java.util.Iterator;


public class CreateStudentCommand implements Command{
	public void execute(Iterator args){
		Student s = new Student();
		s.readNewStudentLoginfo(args);	
		Main.addStudent(s);
		Main.insertStudent(s);
	};
}
