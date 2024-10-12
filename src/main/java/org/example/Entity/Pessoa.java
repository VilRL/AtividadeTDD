package org.example.Entity;

import java.util.List;

public class Pessoa {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;

    public Pessoa(int id, String name, int age, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Email> getEmails() {
        return emails;
    }
}

