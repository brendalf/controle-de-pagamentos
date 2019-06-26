/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.collection.PagamentosCollection;
import gestaopagamentos.observer.IObserver;
import gestaopagamentos.view.ListarPagamentosView;
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
public class ListarPagamentosPresenter implements IObserver {
    private ListarPagamentosView view;
    private DefaultTableModel tableModel;
    
    public ListarPagamentosPresenter() {
        this.view = new ListarPagamentosView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                PagamentosCollection.getInstance().removeObserver(ListarPagamentosPresenter.this);
            }            
        });
        this.view.setVisible(true);
        this.view.setTitle("Listar Pagamentos");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.view.getBtNovoPagamento().addActionListener((ActionEvent e) -> {
            goToAddPagamento();
        });
        
        Object colunas[] = {"Descrição", "Valor", "Data de Vencimento", "Solicitante", "Cargo", "Situacao", "Aprovado por"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.view.getTablePagamentos().setModel(this.tableModel);
        fillTable();
        
        PagamentosCollection.getInstance().registerObserver(this);
    }
    
    private void goToAddPagamento() {
        AdicionarPagamentoPresenter presenter = new AdicionarPagamentoPresenter();
    }

    private void dispose() {
        PagamentosCollection.getInstance().removeObserver(this);
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void fillTable() {
        clearTable();
        
        PagamentosCollection.getInstance().getPagamentos().forEach((pagamento) -> {
            this.tableModel.addRow(
                    new Object[]{
                        pagamento.getDescricao(),
                        pagamento.getValor(),
                        pagamento.getDataVencimento().toString(),
                        pagamento.getSolicitante().getNome(),
                        pagamento.getSolicitante().getCargo(),
                        pagamento.getSituacaoNome(),
                        ""
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
