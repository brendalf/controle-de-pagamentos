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
public class EditarFuncionarioState extends FuncionarioState{
    
    public EditarFuncionarioState(ManterFuncionarioPresenter presenter) {
        super(presenter);
    }
    
    @Override
    public void excluir() {
        try {            
            Funcionario funcionario = this.presenter.getFuncionario();
            FuncionariosCollection.getInstance().removeFuncionario(funcionario);
            
            JOptionPane.showMessageDialog(this.presenter.getView(), "Funcionario excluido com sucesso");
            this.presenter.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.presenter.getView(), e.getMessage());
        }
    }

    @Override
    public void salvar() {
        try {
            String nome = this.presenter.getView().getTxtNome().getText();
            int idade = Integer.parseInt(this.presenter.getView().getTxtIdade().getText());
            int faltas = Integer.parseInt(this.presenter.getView().getTxtFaltas().getText());
            String cargo = (String) this.presenter.getView().getListCargo().getSelectedItem();
            
            Funcionario funcionario = this.presenter.getFuncionario();
            funcionario.setNome(nome);
            funcionario.setIdade(idade);
            funcionario.setCargo(cargo);
            funcionario.setFaltas(faltas);
            FuncionariosCollection.getInstance().notifyObservers();
            
            JOptionPane.showMessageDialog(this.presenter.getView(), "Funcionario editado com sucesso");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.presenter.getView(), "Idade/Faltas devem ser um numeral");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.presenter.getView(), e.getMessage());
        }
    }
}
