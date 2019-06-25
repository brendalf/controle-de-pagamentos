/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.view.ListarFuncionariosView;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class ListarFuncionariosPresenter {
    private ListarFuncionariosView view;
    private DefaultTableModel tableModel;
    
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
               
        Object colunas[] = {"Nome", "Cargo", "Idade", "Faltas"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.view.getTableFuncionarios().setModel(this.tableModel);
        fillTable();
    }
    
    private void goToAddFuncionario() {
        AdicionarFuncionarioPresenter presenter = new AdicionarFuncionarioPresenter();
    }

    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void fillTable() {
        clearTable();
        
        FuncionariosCollection.getInstance().getFuncionarios().forEach((funcionario) -> {
            this.tableModel.addRow(
                    new Object[]{
                        funcionario.getNome(),
                        funcionario.getCargo(),
                        funcionario.getIdade(),
                        funcionario.getNumeroFaltas()
                    }
            );
        });
    }
    
    private void clearTable() {
        while(this.tableModel.getRowCount() > 0)
            this.tableModel.removeRow(0);
    }
}
