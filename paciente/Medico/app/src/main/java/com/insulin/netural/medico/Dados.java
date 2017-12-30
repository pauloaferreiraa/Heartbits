package com.insulin.netural.medico;

/**
 * Created by Miguel on 18/11/2017.
 */

public class Dados {

    static Pessoa pessoa;
    static Destino destino;
    static int nUser = 1;

    public static void addPessoa(Pessoa p) {
        pessoa = new Pessoa(p.getNome(), p.getAge(), p.getSex());
    }

    public static void addDestino(Destino d) {
        destino = new Destino(d.getNome(), d.getDta_arrival(), d.getDta_departure(), d.getCity(), d.getCountrySp());
    }

}
