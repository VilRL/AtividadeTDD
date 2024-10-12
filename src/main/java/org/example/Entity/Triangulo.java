package org.example.Entity;

public class Triangulo {

    public String tipoTriangulo(int ladoA, int ladoB, int ladoC) {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            return "Valores inválidos";
        }

        if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA) {
            return "Não forma triângulo";
        }

        if (ladoA == ladoB && ladoB == ladoC) {
            return "Equilátero";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }

    }
}
