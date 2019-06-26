/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.state;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.presenter.ManterFuncionarioPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class AddFuncionarioState extends FuncionarioState {

    public AddFuncionarioState(ManterFuncionarioPresenter view) {
        super(view);
    }

    @Override
    public void salvar() {
        try {
            String nome = this.presenter.getView().getTxtNome().getText();
            int idade = Integer.parseInt(this.presenter.getView().getTxtIdade().getText());
            int faltas = Integer.parseInt(this.presenter.getView().getTxtFaltas().getText());
            String cargo = (String) this.presenter.getView().getListCargo().getSelectedItem();
            
            Funcionario funcionario = new Funcionario(nome, cargo, idade, faltas);
            FuncionariosCollection.getInstance().addFuncionario(funcionario);
            
            JOptionPane.showMessageDialog(this.presenter.getView(), "Funcionario cadastrado com sucesso");
            this.presenter.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.presenter.getView(), "Idade/Faltas deve ser um numeral");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.presenter.getView(), e.getMessage());
        }
    }
    
}
