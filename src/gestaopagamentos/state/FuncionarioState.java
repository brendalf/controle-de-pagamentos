/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.state;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.presenter.ManterFuncionarioPresenter;

/**
 *
 * @author breno
 */
public abstract class FuncionarioState {
    
    protected ManterFuncionarioPresenter presenter;

    public FuncionarioState(ManterFuncionarioPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void salvar() {
        
    }
    
    public void excluir() {
        
    }
}
