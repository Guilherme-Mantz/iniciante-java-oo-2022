package exceptions;

public class DateException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DateException(String ex) {
		super(ex);
	}
}
