package org.example;

public class Triangulo {
    public static TipoTriangulo tipoTriangulo(int a, int b, int c){
        if(a + b < c || a + c < b || b + c < a)
            return TipoTriangulo.NOESUNTRIANGULO;

        if(a == b && b == c)
            return TipoTriangulo.EQUILATERO;

        if(a != b && b != c)
            return TipoTriangulo.ESCALENO;

        return TipoTriangulo.ISOSCELES;
    }
}
