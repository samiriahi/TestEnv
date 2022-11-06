package backendsolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundExeption extends RuntimeException {
	
	private static final long  serialVersionUID = 1L ;
	
	public UserNotFoundExeption (String message ) {
		super(message ) ;
	}

}
