/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.model;

import gestaopagamentos.business.Funcionario;

/**
 *
 * @author breno
 */
public class Usuario {
    private Funcionario funcionario;
    private String user;
    private String passwd;

    public Usuario(Funcionario funcionario, String user, String passwd) {
        this.funcionario = funcionario;
        this.user = user;
        this.passwd = passwd;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }
}
