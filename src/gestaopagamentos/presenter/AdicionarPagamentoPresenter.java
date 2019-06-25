/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.business.Pagamento;
import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.collection.PagamentosCollection;
import gestaopagamentos.view.AdicionarPagamentoView;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

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
        
        this.view.getBtSalvar().addActionListener((ActionEvent e) -> {
            addPagamento();
        });
        
        fillList();
        
        if(FuncionariosCollection.getInstance().getFuncionarios().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionario cadastrado");
        }
    }
    
    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void addPagamento() {
        try {
            String descricao = this.view.getTxtDescricao().getText();
            String vencimento = this.view.getTxtVencimento().getText();
            float valor = Float.parseFloat(this.view.getTxtValor().getText());
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            Date dataVencimento = df.parse(vencimento);
            
            int funcionarioSelected = this.view.getListFuncionario().getSelectedIndex();
            Funcionario solicitante = FuncionariosCollection.getInstance().getFuncionarios().get(funcionarioSelected);
            Pagamento pagamento = new Pagamento(valor, dataVencimento, descricao, solicitante);
            PagamentosCollection.getInstance().addPagamento(pagamento);
            
            JOptionPane.showMessageDialog(this.view, "Pagamento cadastrado com sucesso");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.view, "Valor deve ser um numeral");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this.view, "Verifique se o formato da data de vencimento");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, e.getMessage());
        }
    }

    private void fillList() {
        FuncionariosCollection.getInstance().getFuncionarios().forEach((funcionario) -> {
            this.view.getListFuncionario().addItem(funcionario.getNome());
        });
    }
}
