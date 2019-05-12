/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author breno
 */
public class LoginPresenter {
    private LoginView view;

    public LoginPresenter() {
        this.view = new LoginView();
        this.view.setVisible(true);
        this.view.getBtAcessar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }
    
    private void login() {
        if(this.view.getInputUsuario().getText().equals("brendalf") && this.view.getInputSenha().getText().equals("123456")) {
            HomePresenter homePresenter = new HomePresenter();
            this.view.setVisible(false);
            this.view.dispose();
        } else {
            // exibe alerta de senha invalida
        }
    }
}
