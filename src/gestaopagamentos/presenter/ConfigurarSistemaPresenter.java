/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.business.AutorizadoraPagamento;
import gestaopagamentos.collection.AutorizadoresCollection;
import gestaopagamentos.view.ConfigurarSistemaView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class ConfigurarSistemaPresenter {
    
    private ConfigurarSistemaView view;
    private DefaultTableModel tableModel;

    public ConfigurarSistemaPresenter() {
        this.view = new ConfigurarSistemaView();
        this.view.setVisible(true);
        this.view.setTitle("Configurar Sistema");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.view.getBtSalvar().addActionListener((ActionEvent e) -> {
            updateAutorizadores();
        });
        
        this.tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Cargo", "Habilitado"}) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        this.view.getTableCargos().setModel(this.tableModel);
        
        fillTable();
    }
    
    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }    

    private void fillTable() {
        clearTable();
        
        AutorizadoresCollection.getInstance().getAutorizadores().forEach((autorizadora) -> {
            this.tableModel.addRow(
                    new Object[]{
                        autorizadora.getNomeAutorizadora(),
                        autorizadora.isMetodoHabilitado()
                    }
            );
        });
    }
    
    private void clearTable() {
        while(this.tableModel.getRowCount() > 0)
            this.tableModel.removeRow(0);
    }

    private void updateAutorizadores() {
        for(int i=0; i < this.tableModel.getRowCount(); i++) {                
            AutorizadoresCollection.getInstance().getAutorizadores().get(i).setMetodoHabilitado((boolean) this.view.getTableCargos().getValueAt(i, 1));
        }
        
        JOptionPane.showMessageDialog(null, "Sistema configurado com sucesso");
        dispose();
    }
}
