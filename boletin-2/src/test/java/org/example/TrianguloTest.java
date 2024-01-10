package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TrianguloTest {



    @ParameterizedTest
    @MethodSource("generateData")
    void tipoTrianguloTest(int a, int b, int c, TipoTriangulo result){
        assertEquals(result, Triangulo.tipoTriangulo(a,b,c));
    }
    public static Stream<Arguments> generateData() {
        return Stream.of(
                arguments(7, 2, 10,  TipoTriangulo.NOESUNTRIANGULO),
                arguments(10, 10, 10,  TipoTriangulo.EQUILATERO),
                arguments(15, 15, 10,  TipoTriangulo.ISOSCELES),
                arguments(7, 5, 10,  TipoTriangulo.ESCALENO)
        );

    }

}
