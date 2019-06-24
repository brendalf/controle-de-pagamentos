/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.view.ListarFuncionariosView;
import java.awt.event.ActionEvent;

/**
 *
 * @author breno
 */
public class ListarFuncionariosPresenter {
    private ListarFuncionariosView view;
    
    public ListarFuncionariosPresenter() {
        this.view = new ListarFuncionariosView();
        this.view.setVisible(true);
        this.view.setTitle("Listar Funcionários");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.view.getBtNovoFuncionario().addActionListener((ActionEvent e) -> {
            goToAddFuncionario();
        });
    }
    
    private void goToAddFuncionario() {
        AdicionarFuncionarioPresenter presenter = new AdicionarFuncionarioPresenter();
    }

    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }
}
