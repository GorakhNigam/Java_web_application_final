package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Library {
	@Value("5")
	private int booksDue;

	public int getBooksDue() {
		return booksDue;
	}

	public void setBooksDue(int booksDue) {
		this.booksDue = booksDue;
	}
	
}
