package org.example.Entity;

import org.example.Enum.Cargo;

public class Funcionario {
    private String nome;
    private String email;
    private double salarioBase;
    private Cargo cargo;

    public Funcionario(String nome, String email, double salarioBase, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
