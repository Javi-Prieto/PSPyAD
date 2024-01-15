package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.calificacion.DTO.POSTCalificacionDTO;
import dam.salesianostriana.dam.GradesAPP.calificacion.model.Calificacion;
import dam.salesianostriana.dam.GradesAPP.calificacion.repository.CalificacionRepository;
import dam.salesianostriana.dam.GradesAPP.calificacion.service.CalificacionService;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalificacionTest {
    @Mock
    CalificacionRepository repo;
    @Mock
    InstrumentoRepository repoIns;
    @Mock
    AsignaturaRepository repoAs;
    @Mock
    AlumnoRepository repoAl;
    @InjectMocks
    CalificacionService service;

    public static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments("1", POSTCalificacionDTO.builder().calificacion(9.37).codRef("1").idAlumno("1").build()),
                Arguments.arguments("0", POSTCalificacionDTO.builder().calificacion(9.37).codRef("1").idAlumno("0").build())
        );
    }

    @ParameterizedTest
    @MethodSource("getData")
    void createCalificacion(UUID id, POSTCalificacionDTO newCal){
        Asignatura asignatura = Asignatura.builder().build();
        Instrumento selected = Instrumento.builder()
                .fecha(LocalDate.now())
                .referentes(Set.of())
                .asignatura(asignatura)
                .contenidos("Hola")
                .id(UUID.fromString("1"))
                .build();
        Optional<Alumno> selectedAl = Optional.of(Alumno.builder()
                .asignaturas(Set.of(asignatura))
                        .nombre("juan")
                        .email("hola@juan.com")
                        .apellidos("gonzalez")
                .build());

        List<ReferenteEvaluacion> referentes = List.of(ReferenteEvaluacion.builder().codReferente("1").asignatura(asignatura).descripcion("desc").build());
        if (id.toString().equals("1")) {
            Mockito.when(repoIns.existsById(id)).thenReturn(true);
            Mockito.when(repoIns.getReferenceById(id)).thenReturn(selected);
            Mockito.when(repoAl.findById(UUID.fromString(newCal.idAlumno()))).thenReturn(selectedAl);
            Mockito.when(repoAs.getAllReferentes()).thenReturn(referentes);
            if(newCal.codRef().equals("1")){

            }else{

            }
        }
        else {
            Mockito.when(repoIns.existsById(id)).thenReturn(false);
            Throwable throwable = assertThrows(NotFoundException.class, () ->{
                service.createCalificacion(id, newCal);
            });
            assertEquals("The Instrumento or the list could not be found",throwable.getMessage());
        }





    }
}
