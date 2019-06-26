/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.business.Pagamento;
import gestaopagamentos.view.VerDetalhesPagamentoView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class VerDetalhesPagamentoPresenter {
    
    private VerDetalhesPagamentoView view;
    private DefaultTableModel tableModel;
    
    private Pagamento pagamento;

    public VerDetalhesPagamentoPresenter(Pagamento pagamento) {
        this.view = new VerDetalhesPagamentoView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.view.setVisible(true);
        this.view.setTitle("Detalhes do Pagamento");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.pagamento = pagamento;
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.view.getTxtDescricao().setText(this.pagamento.getDescricao());
        this.view.getTxtValor().setText(String.valueOf(this.pagamento.getValor()));
        this.view.getTxtVencimento().setText(df.format(this.pagamento.getDataVencimento()));
        this.view.getTxtSolicitante().setText(this.pagamento.getSolicitante().getNome()
                + " (" + this.pagamento.getSolicitante().getCargo() + ")");
        this.view.getTxtSituacao().setText(this.pagamento.getSituacao());
        this.view.getTxtAprovador().setText(pagamento.getAprovador() != null ? pagamento.getAprovador().getNome() : "");
        
        Object colunas[] = {"Ação", "Data", "Usuario"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.view.getTableDetalhes().setModel(this.tableModel);
        fillTable();
    }
    
    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void fillTable() {
        clearTable();
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.pagamento.getDetalhes().forEach((detalhe) -> {
            this.tableModel.addRow(
                    new Object[]{
                        detalhe.getDescricao(),
                        df.format(detalhe.getData()),
                        detalhe.getUsuario()
                    }
            );
        });
    }
    
    private void clearTable() {
        while(this.tableModel.getRowCount() > 0)
            this.tableModel.removeRow(0);
    }   
}
