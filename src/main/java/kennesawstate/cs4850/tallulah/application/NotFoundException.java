package kennesawstate.cs4850.tallulah.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such ID")
public class NotFoundException extends RuntimeException {
}
