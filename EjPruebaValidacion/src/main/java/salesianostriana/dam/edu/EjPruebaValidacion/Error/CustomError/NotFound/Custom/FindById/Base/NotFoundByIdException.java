package salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindById.Base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Base.NotFoundException;

public class NotFoundByIdException extends NotFoundException {
    NotFoundByIdException(){
        super(asDetails());
    }
    protected NotFoundByIdException(ProblemDetail detail){
        super(detail);
    }
    private  static ProblemDetail asDetails(){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Not found By Id");
    }
}
