/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.observer.IObserver;
import gestaopagamentos.view.ListarFuncionariosView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class ListarFuncionariosPresenter implements IObserver {
    
    private ListarFuncionariosView view;
    private DefaultTableModel tableModel;
    
    public ListarFuncionariosPresenter() {
        this.view = new ListarFuncionariosView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                FuncionariosCollection.getInstance().removeObserver(ListarFuncionariosPresenter.this);
            }            
        });
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
        
        FuncionariosCollection.getInstance().registerObserver(this);
    }
    
    private void goToAddFuncionario() {
        AdicionarFuncionarioPresenter presenter = new AdicionarFuncionarioPresenter();
    }

    private void dispose() {
        FuncionariosCollection.getInstance().removeObserver(this);
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

    @Override
    public void update() {
        fillTable();
    }
}
