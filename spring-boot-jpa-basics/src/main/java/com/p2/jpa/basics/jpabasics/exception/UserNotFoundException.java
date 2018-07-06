package com.p2.jpa.basics.jpabasics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*In case of UserNotFoundException , give 404. Error response will be in default structure
**For custom structure CustomResponseEntityExceptionHandler used
**/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
