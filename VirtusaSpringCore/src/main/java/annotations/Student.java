package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("888")
	private int regno;
	@Value("Virtusa")
	private String stdname;
	@Value("600")
	private int total;
	@Autowired
	private Library library;
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Student(int regno, String stdname, int total, Library library) {
		super();
		this.regno = regno;
		this.stdname = stdname;
		this.total = total;
		this.library = library;
	}
	public Student() {
		super();
	}
	
}
