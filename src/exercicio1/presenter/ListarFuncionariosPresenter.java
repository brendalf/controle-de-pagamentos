/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.presenter;

import exercicio1.view.ListarFuncionariosView;

/**
 *
 * @author breno
 */
public class ListarFuncionariosPresenter {
    private ListarFuncionariosView listarView;
    
    public ListarFuncionariosPresenter() {
        this.listarView = new ListarFuncionariosView();
        this.listarView.setVisible(true);
        this.listarView.setTitle("Listar Funcionários");
    }
    
}
