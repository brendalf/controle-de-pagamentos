/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.collection.PagamentosCollection;
import gestaopagamentos.view.ListarPagamentosView;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class ListarPagamentosPresenter {
    private ListarPagamentosView view;
    private DefaultTableModel tableModel;
    
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
        
        Object colunas[] = {"Descrição", "Valor", "Data de Vencimento", "Solicitante", "Cargo", "Aprovado por"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.view.getTablePagamentos().setModel(this.tableModel);
        fillTable();
    }
    
    private void goToAddPagamento() {
        AdicionarPagamentoPresenter presenter = new AdicionarPagamentoPresenter();
    }

    private void dispose() {
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
                        ""
                    }
            );
        });
    }
    
    private void clearTable() {
        while(this.tableModel.getRowCount() > 0)
            this.tableModel.removeRow(0);
    }
}
