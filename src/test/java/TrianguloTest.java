import org.example.Triangulo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianguloTest {

    static Stream<Arguments> triangleArguments() {
        return Stream.of(
                Arguments.of(4, 5, 6, "Escaleno"),
                Arguments.of(10, 10, 10, "Equilátero"),
                Arguments.of(5, 5, 3, "Isósceles")
        );
    }

    static Stream<Arguments> testIsoscelesWithDifferentOrder(){
        return Stream.of(
                Arguments.of(5,5,3, "Isósceles"),
                Arguments.of(5,3,5, "Isósceles"),
                Arguments.of(3,5,5, "Isósceles")
        );
    };

    static Stream<Arguments> testIsoscelesWithAnotherSet(){
        return Stream.of(
                Arguments.of(7,7,4, "Isósceles"),
                Arguments.of(7,4,7, "Isósceles"),
                Arguments.of(4,7,7, "Isósceles")
        );
    };

    @ParameterizedTest
    @MethodSource("triangleArguments")
    void isTypeTriangle(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    @ParameterizedTest
    @MethodSource("testIsoscelesWithDifferentOrder")
    void isTypeIsosceles(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    @ParameterizedTest
    @MethodSource("testIsoscelesWithAnotherSet")
    void isTypeIsoscelesAnotherSet(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    @Test
    public void testIsoscelesWithEqualSides() {
        Triangulo triangulo = new Triangulo();

        // Teste 1: lados 10, 10, 10 (todos os lados iguais, triângulo equilátero)
        assertEquals("Equilátero", triangulo.tipoTriangulo(10, 10, 10));

        // Teste 2: lados 10, 10, 5 (isósceles)
        assertEquals("Isósceles", triangulo.tipoTriangulo(10, 10, 5));

        // Teste 3: lados 5, 10, 10 (permutação)
        assertEquals("Isósceles", triangulo.tipoTriangulo(5, 10, 10));
    }

    @Test
    public void testInvalidValues() {
        Triangulo triangulo = new Triangulo();

        // Teste 1: lados negativos
        assertEquals("Valores inválidos", triangulo.tipoTriangulo(-1, 5, 3));

        // Teste 2: lado zero
        assertEquals("Valores inválidos", triangulo.tipoTriangulo(0, 5, 3));

        // Teste 3: lados todos zero
        assertEquals("Valores inválidos", triangulo.tipoTriangulo(0, 0, 0));
    }

    @Test
    public void testNoTriangle() {
        Triangulo triangulo = new Triangulo();

        // Teste: lados que não formam triângulo
        assertEquals("Não forma triângulo", triangulo.tipoTriangulo(1, 2, 3));
    }
}
