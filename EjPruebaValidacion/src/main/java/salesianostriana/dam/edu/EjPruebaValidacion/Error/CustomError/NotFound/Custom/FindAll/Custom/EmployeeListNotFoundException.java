package salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindAll.Custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindAll.Base.NotFoundListException;

import java.net.URI;
import java.time.Instant;

public class EmployeeListNotFoundException extends NotFoundListException {
    public EmployeeListNotFoundException(String entity){
        super(asProblemDetails("Not found the " + entity + " list"));
    }
    private static ProblemDetail asProblemDetails(String s){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, s);
        problemDetail.setTitle("Employee List Not Found");
        problemDetail.setType(URI.create("https://api.employee.com/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
