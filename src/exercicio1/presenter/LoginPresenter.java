/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.presenter;

import exercicio1.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author breno
 */
public class LoginPresenter {
    private LoginView loginView;

    public LoginPresenter() {
        this.loginView = new LoginView();
        this.loginView.setVisible(true);
        this.loginView.getBtAcessar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }
    
    private void login() {
        if(this.loginView.getInputUsuario().getText().equals("brendalf") && this.loginView.getInputSenha().getText().equals("123456")) {
            HomePresenter homePresenter = new HomePresenter();
            this.loginView.setVisible(false);
            this.loginView.dispose();
        } else {
            // exibe alerta de senha invalida
        }
    }
}
