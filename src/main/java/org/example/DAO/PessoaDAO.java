package org.example.DAO;

import org.example.Entity.Email;
import org.example.Entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public List<String> isValidToInclude(Pessoa pessoa) {
        List<String> erros = new ArrayList<>();

        String name = pessoa.getName();
        if (!name.matches("[a-zA-Z]+( [a-zA-Z]+)+")) {
            if (name.split(" ").length < 2) {
                erros.add("Nome deve ser composto por pelo menos duas partes");
            } else {
                erros.add("Nome deve conter apenas letras");
            }
        }

        int age = pessoa.getAge();
        if (age < 1 || age > 200) {
            erros.add("Idade deve estar entre 1 e 200");
        }

        List<Email> emails = pessoa.getEmails();
        if (emails.isEmpty()) {
            erros.add("Pessoa deve ter pelo menos um email associado");
        } else {
            for (Email email : emails) {
                if (!email.getName().matches("^[^@]+@[^@]+\\.[^@]+$")) {
                    erros.add("Email inválido: " + email.getName());
                }
            }
        }

        return erros;
    }

    public void save(Pessoa pessoa) {
    }
}
