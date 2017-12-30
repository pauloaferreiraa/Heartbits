package com.insulin.netural.medico;

import java.util.Date;

/**
 * Created by Miguel on 19/11/2017.
 */

public class Destino {
    private String dta_arrival;
    private String dta_departure;
    private String city;
    private String countrySp;
    private String nome;

    public Destino(String n, String dta_a, String dta_d, String c, String cSp) {
        this.dta_arrival = dta_a;
        this.dta_departure = dta_d;
        this.city = c;
        this.countrySp = cSp;
        this.nome = n;
    }

    public String getNome() {
        return nome;
    }

    public String getCity() {
        return city;
    }

    public String getCountrySp() {
        return countrySp;
    }

    public String getDta_arrival() {
        return dta_arrival;
    }

    public String getDta_departure() {
        return dta_departure;
    }
}
