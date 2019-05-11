/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.presenter;

import exercicio1.view.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author breno
 */
public class HomePresenter {
    private HomeView homeView;
    
    public HomePresenter() {
        this.homeView = new HomeView();
        this.homeView.setVisible(true);
        this.homeView.setTitle("Sistema");
        
        this.homeView.getMenuConsultarFunc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToListarFuncionarios();
            }
        });
    }
    
    private void goToListarFuncionarios() {
        ListarFuncionariosPresenter listarFuncionariosPresenter = new ListarFuncionariosPresenter();
    }

    private void goToAddFuncionario() {
        
    }
    
    private void goToAddPagamento() {
        
    }
    
    private void goToListarPagamentos() {
        
    }
}
