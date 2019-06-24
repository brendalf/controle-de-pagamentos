/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.view.ConfigurarSistemaView;
import java.awt.event.ActionEvent;

/**
 *
 * @author breno
 */
public class ConfigurarSistemaPresenter {
    private ConfigurarSistemaView view;

    public ConfigurarSistemaPresenter() {
        this.view = new ConfigurarSistemaView();
        this.view.setVisible(true);
        this.view.setTitle("Listar Pagamentos");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
    }
    
    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }    
}
