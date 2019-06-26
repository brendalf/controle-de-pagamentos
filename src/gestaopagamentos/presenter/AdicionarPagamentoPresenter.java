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
import gestaopagamentos.observer.IObserver;
import gestaopagamentos.view.AdicionarPagamentoView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author breno
 */
public class AdicionarPagamentoPresenter implements IObserver {
    
    private AdicionarPagamentoView view;
    private DefaultTableModel tableModel;
    
    public AdicionarPagamentoPresenter() {
        this.view = new AdicionarPagamentoView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                FuncionariosCollection.getInstance().removeObserver(AdicionarPagamentoPresenter.this);
            }            
        });
        this.view.setVisible(true);
        this.view.setTitle("Novo Pagamento");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.view.getBtSalvar().addActionListener((ActionEvent e) -> {
            addPagamento();
        });
        
        Object colunas[] = {"Nome", "Cargo", "Idade", "Faltas"};
        this.tableModel = new DefaultTableModel(colunas, 0);
        this.view.getTableFuncionarios().setModel(this.tableModel);
        fillTable();
        
        FuncionariosCollection.getInstance().registerObserver(this);
    }
    
    private void dispose() {
        FuncionariosCollection.getInstance().removeObserver(this);
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void addPagamento() {
        try {
            String descricao = this.view.getTxtDescricao().getText();
            String vencimento = this.view.getTxtVencimento().getText();
            float valor = Float.parseFloat(this.view.getTxtValor().getText());
            
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dataVencimento = df.parse(vencimento);
            
            int funcionarioSelected = this.view.getTableFuncionarios().getSelectedRow();
            if(funcionarioSelected == -1) {
                JOptionPane.showMessageDialog(this.view, "Selecione um funcionario como solicitante");
                return;
            }
            
            Funcionario solicitante = FuncionariosCollection.getInstance().getFuncionarios().get(funcionarioSelected);
            
            if(solicitante.getFaltas() > 15) {
                JOptionPane.showMessageDialog(this.view, "Solicitante possui mais de 15 faltas");
                return;
            }                
            
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

    private void fillTable() {
        clearTable();
        
        if(FuncionariosCollection.getInstance().getFuncionarios().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionario cadastrado");
        }
        
        FuncionariosCollection.getInstance().getFuncionarios().forEach((funcionario) -> {
            this.tableModel.addRow(
                    new Object[]{
                        funcionario.getNome(),
                        funcionario.getCargo(),
                        funcionario.getIdade(),
                        funcionario.getFaltas()
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
