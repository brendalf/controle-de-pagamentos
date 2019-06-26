/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.collection.UsuarioLogado;
import gestaopagamentos.view.LoginView;
import gestaopagamentos.model.Usuario;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class LoginPresenter {
    private LoginView view;
    private ArrayList<Usuario> usuarios;

    public LoginPresenter() {
        this.view = new LoginView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setVisible(true);
        
        this.view.getBtAcessar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        
        try {
            this.usuarios = new ArrayList<>();
            this.usuarios.add(new Usuario(new Funcionario("Breno Silva", "Diretor Geral", 23), "brendalf", "123456"));
            this.usuarios.add(new Usuario(new Funcionario("Clayton Fraga", "Diretor Financeiro", 35), "claytonfraga", "123456"));
            this.usuarios.add(new Usuario(new Funcionario("Bruno Silva", "Gerente Geral", 23), "brunob803", "123456"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, "Erro ao inicializar usuarios");
        }
    }
    
    private void login() {
        String nome = this.view.getInputUsuario().getText();
        String senha = this.view.getInputSenha().getText();
        
        Usuario usuarioLogado = null;
        Iterator<Usuario> it = this.usuarios.iterator();
        while(it.hasNext() && usuarioLogado == null) {
            Usuario validador = it.next();
            if(validador.getUser().equals(nome) && validador.getPasswd().equals(senha)) {
                usuarioLogado = validador;
            }
        }
        
        if(usuarioLogado != null) {
            UsuarioLogado.getInstance().setUsuario(usuarioLogado);
            HomePresenter homePresenter = new HomePresenter();
            this.view.setVisible(false);
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(this.view, "Usuario ou senha invalidos");
        }
    }
}
