/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class DetalhePagamento {
    private Date data;
    private String descricao;
    private String usuario;

    public DetalhePagamento(Date data, String descricao, String usuario) {
        this.data = data;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }
    public String getDescricao() {
        return descricao;
    }

    public String getUsuario() {
        return usuario;
    }
}
