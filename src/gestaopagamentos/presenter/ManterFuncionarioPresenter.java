/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.state.AddFuncionarioState;
import gestaopagamentos.state.EditarFuncionarioState;
import gestaopagamentos.state.FuncionarioState;
import gestaopagamentos.view.ManterFuncionarioView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author breno
 */
public class ManterFuncionarioPresenter {
    
    private ManterFuncionarioView view;
    private Funcionario funcionario;
    private FuncionarioState contexto;
    
    public ManterFuncionarioPresenter() {
        this.view = new ManterFuncionarioView();
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
            salvar();
        });
        
        this.view.getBtExcluirFuncionario().addActionListener((ActionEvent e) -> {
            excluir();
        });
        this.view.getBtExcluirFuncionario().setVisible(false);
        
        this.contexto = new AddFuncionarioState(this);
    }
    
    public ManterFuncionarioPresenter(Funcionario funcionario) {
        this();
        
        this.funcionario = funcionario;
        this.view.getBtExcluirFuncionario().setVisible(true);
        
        this.view.getTxtNome().setText(this.funcionario.getNome());
        this.view.getTxtIdade().setText(String.valueOf(this.funcionario.getIdade()));
        this.view.getTxtFaltas().setText(String.valueOf(this.funcionario.getFaltas()));
        this.view.getListCargo().setSelectedItem(this.funcionario.getCargo());
        
        this.contexto = new EditarFuncionarioState(this);
    }
    
    public void dispose() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    public ManterFuncionarioView getView() {
        return view;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    private void salvar() {
        this.contexto.salvar();
    }
    
    private void excluir() {
        this.contexto.excluir();
    }
}
