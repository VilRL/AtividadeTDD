package org.example.Service;

import org.example.Enum.Cargo;
import org.example.Entity.Funcionario;

public class CalculadoraSalario {

    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        Cargo cargo = funcionario.getCargo();

        switch (cargo) {
            case DESENVOLVEDOR:
                return calcularSalarioDesenvolvedor(salarioBase);
            case DBA:
            case TESTADOR:
                return calcularSalarioDbaOuTestador(salarioBase);
            case GERENTE:
                return calcularSalarioGerente(salarioBase);
            default:
                throw new IllegalArgumentException("Cargo inválido");
        }
    }

    private double calcularSalarioDesenvolvedor(double salarioBase) {
        if (salarioBase >= 3000) {
            return salarioBase * 0.8;
        } else {
            return salarioBase * 0.9;
        }
    }

    private double calcularSalarioDbaOuTestador(double salarioBase) {
        if (salarioBase >= 2000) {
            return salarioBase * 0.75;
        } else {
            return salarioBase * 0.85;
        }
    }

    private double calcularSalarioGerente(double salarioBase) {
        if (salarioBase >= 5000) {
            return salarioBase * 0.7;
        } else {
            return salarioBase * 0.8;
        }
    }
}

