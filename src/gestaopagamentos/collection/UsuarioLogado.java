/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.collection;

import gestaopagamentos.model.Usuario;

/**
 *
 * @author breno
 */
public class UsuarioLogado {
    
    private Usuario usuario;
    private static UsuarioLogado instance;
    
    public static UsuarioLogado getInstance(){
        if(instance == null){
            instance = new UsuarioLogado();
        }
        return instance;
    }
    
    private UsuarioLogado() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
