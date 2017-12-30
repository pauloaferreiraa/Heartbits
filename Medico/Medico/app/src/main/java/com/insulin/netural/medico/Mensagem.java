package com.insulin.netural.medico;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by joao Gomes on 19/11/2017.
 */

public class Mensagem implements Serializable{
    public String msg;
    public String user;

    public Mensagem(String user, String msg) {
        this.msg = msg;
        this.user = user;
    }
    public Mensagem(Map<String, Object> mapa) {
        this.msg = (String) mapa.get("msg");
        this.user = (String) mapa.get("user");

    }

    public String getMsg() {
        return msg;
    }
    public String toString(){

            return "\n"+user+":"+msg;


    }
}
