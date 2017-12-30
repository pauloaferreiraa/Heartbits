package com.insulin.netural.medico;

/**
 * Created by Miguel on 18/11/2017.
 */

public class Pessoa {

    private String nome;
    private String age;
    private String sex;

    public Pessoa(String n, String a, String s) {
        this.nome = n;
        this.age = a;
        this.sex = s;
    }

    public String getNome() {
        return nome;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
