/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.view.ListarPagamentosView;
import java.awt.event.ActionEvent;

/**
 *
 * @author breno
 */
public class ListarPagamentosPresenter {
    private ListarPagamentosView view;
    
    public ListarPagamentosPresenter() {
        this.view = new ListarPagamentosView();
        this.view.setVisible(true);
        this.view.setTitle("Listar Pagamentos");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.view.getBtNovoPagamento().addActionListener((ActionEvent e) -> {
            goToAddPagamento();
        });
    }
    
    private void goToAddPagamento() {
        AdicionarPagamentoPresenter presenter = new AdicionarPagamentoPresenter();
    }

    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }
}
