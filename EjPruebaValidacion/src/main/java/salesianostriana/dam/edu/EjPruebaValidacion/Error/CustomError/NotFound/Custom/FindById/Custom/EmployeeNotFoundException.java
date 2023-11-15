package salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindById.Custom;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
import salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Base.NotFoundException;
import salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindById.Base.NotFoundByIdException;

import java.net.URI;
import java.time.Instant;

public class EmployeeNotFoundException extends NotFoundByIdException {
    public EmployeeNotFoundException(Long idEmployee){
        super(asProblemDetail("Employee with id " + idEmployee + " not found"));
    }

    private static ProblemDetail asProblemDetail(String s) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, s);
        problemDetail.setTitle("Employee Not Found");
        problemDetail.setType(URI.create("https://api.employee.com/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}

