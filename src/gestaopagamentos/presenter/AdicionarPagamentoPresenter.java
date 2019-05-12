/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.view.AdicionarPagamentoView;
import java.awt.event.ActionEvent;

/**
 *
 * @author breno
 */
public class AdicionarPagamentoPresenter {
    private AdicionarPagamentoView view;
    
    public AdicionarPagamentoPresenter() {
        this.view = new AdicionarPagamentoView();
        this.view.setVisible(true);
        this.view.setTitle("Novo Pagamento");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
    }
    
    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }
}
