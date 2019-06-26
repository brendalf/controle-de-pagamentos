/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.view.AdicionarFuncionarioView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class AdicionarFuncionarioPresenter {
    
    private AdicionarFuncionarioView view;
    
    public AdicionarFuncionarioPresenter() {
        this.view = new AdicionarFuncionarioView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.view.setVisible(true);
        this.view.setTitle("Novo Funcionário");
        
        this.view.getBtCancelar().addActionListener((ActionEvent e) -> {
            dispose();
        });
        
        this.view.getBtSalvar().addActionListener((ActionEvent e) -> {
            addFuncionario();
        });
    }
    
    private void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void addFuncionario() {
        try {
            String nome = this.view.getTxtNome().getText();
            int idade = Integer.parseInt(this.view.getTxtIdade().getText());
            String cargo = (String) this.view.getListCargo().getSelectedItem();
            
            Funcionario funcionario = new Funcionario(nome, cargo, idade);
            FuncionariosCollection.getInstance().addFuncionario(funcionario);
            
            JOptionPane.showMessageDialog(this.view, "Funcionario cadastrado com sucesso");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.view, "Idade deve ser um numeral");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, e.getMessage());
        }
    }
}
