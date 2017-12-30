package com.insulin.netural.medico;

import java.io.Serializable;
import java.util.List;

/**
 * Created by joao Gomes on 19/11/2017.
 */

public class User implements Serializable
{
    public String nome;
    public boolean lida;
    public List<Mensagem> Chat;

    public User(String nome, boolean lida, List<Mensagem> chat) {
        this.nome = nome;
        this.lida = lida;
        Chat = chat;
    }
}
