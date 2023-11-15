package salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Base;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public abstract class NotFoundException extends ErrorResponseException {
    public NotFoundException(ProblemDetail detail) {
        super(HttpStatus.NOT_FOUND, detail, null);
    }
    public NotFoundException(){
        super(HttpStatus.NOT_FOUND, asDetails(), null);
    }
    private static ProblemDetail asDetails(){
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Not Found");
        return detail;
    }
}
