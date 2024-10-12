import org.example.Entity.Triangulo;
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
    @ParameterizedTest
    @MethodSource("triangleArguments")
    void tipoDoTriangulo(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> IsoscelesEmOrdensDiferente(){
        return Stream.of(
                Arguments.of(5,5,3, "Isósceles"),
                Arguments.of(5,3,5, "Isósceles"),
                Arguments.of(3,5,5, "Isósceles")
        );
    };
    @ParameterizedTest
    @MethodSource("IsoscelesEmOrdensDiferente")
    void isoscelesEmOrdensDiferente(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> isoscelesComOutraSequencia(){
        return Stream.of(
                Arguments.of(7,7,4, "Isósceles"),
                Arguments.of(7,4,7, "Isósceles"),
                Arguments.of(4,7,7, "Isósceles")
        );
    };
    @ParameterizedTest
    @MethodSource("isoscelesComOutraSequencia")
    void isoscelesComOutraSequencia(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> isoscelesComTodosLadosIguais(){
        return Stream.of(
                Arguments.of(10,10,10, "Equilátero"),
                Arguments.of(10,10,5, "Isósceles"),
                Arguments.of(5,10,10, "Isósceles")
        );
    };
    @ParameterizedTest
    @MethodSource("isoscelesComTodosLadosIguais")
    void isoscelesComTodosLadosIguais(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> valorZerado() {
        return Stream.of(
                Arguments.of(0, 5, 3, "Valores inválidos"),
                Arguments.of(5, 0, 3, "Valores inválidos"),
                Arguments.of(5, 3, 0, "Valores inválidos")
        );
    }
    @ParameterizedTest
    @MethodSource("valorZerado")
    void valorZerado(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> valorNegativo() {
        return Stream.of(
                Arguments.of(-1, 5, 3, "Valores inválidos"),
                Arguments.of(5, -1, 3, "Valores inválidos"),
                Arguments.of(5, 3, -1, "Valores inválidos")
        );
    }
    @ParameterizedTest
    @MethodSource("valorNegativo")
    void valorNegativo(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> doisLadosIgualAoTerceiro() {
        return Stream.of(
                Arguments.of(3, 1, 2, "Não forma triângulo"),
                Arguments.of(1, 3, 2, "Não forma triângulo"),
                Arguments.of(2, 1, 3, "Não forma triângulo")
        );
    }
    @ParameterizedTest
    @MethodSource("doisLadosIgualAoTerceiro")
    void somDoisLadosIgualAoTerceiro(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    static Stream<Arguments> somaDoisLadosMenorQueOTerceiro() {
        return Stream.of(
                Arguments.of(1, 2, 4, "Não forma triângulo"),
                Arguments.of(2, 4, 1, "Não forma triângulo"),
                Arguments.of(4, 1, 2, "Não forma triângulo")
        );
    }
    @ParameterizedTest
    @MethodSource("somaDoisLadosMenorQueOTerceiro")
    void somaDoisLadosMenorQueOTerceiro(int A, int B, int C, String expected) {
        Triangulo triangulo = new Triangulo();
        assertEquals(expected, triangulo.tipoTriangulo(A, B, C));
    }

    @Test
    public void tudoZerado() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Valores inválidos", triangulo.tipoTriangulo(0, 0, 0));
    }
}
