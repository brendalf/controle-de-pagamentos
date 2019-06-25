/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.persistence.SalvarDados;
import gestaopagamentos.view.HomeView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

/**
 *
 * @author breno
 */
public class HomePresenter {
    private HomeView view;
    
    public HomePresenter() {
        this.view = new HomeView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.setVisible(true);
        this.view.setTitle("Sistema de Gestão de Pagamentos");
        
        this.view.getMenuConsultarFunc().addActionListener((ActionEvent e) -> {
            goToListarFuncionarios();
        });
        
        this.view.getMenuRegistrarFunc().addActionListener((ActionEvent e) -> {
            goToAddFuncionario();
        });
        
        this.view.getMenuRegistrarPag().addActionListener((ActionEvent e) -> {
            goToAddPagamento();
        });
        
        this.view.getMenuConsultarPag().addActionListener((ActionEvent e) -> {
            goToListarPagamentos();
        });
        
        this.view.getMenuExportarDados().addActionListener((ActionEvent e) -> {
            goToExportarDados();
        });
        
        this.view.getMenuImportarDados().addActionListener((ActionEvent e) -> {
            goToImportarDados();
        });
        
        this.view.getMenuConfigSistema().addActionListener((ActionEvent e) -> {
            goToConfigSistema();
        });
    }
    
    private void goToListarFuncionarios() {
        ListarFuncionariosPresenter presenter = new ListarFuncionariosPresenter();
    }

    private void goToAddFuncionario() {
        AdicionarFuncionarioPresenter presenter = new AdicionarFuncionarioPresenter();
    }
    
    private void goToAddPagamento() {
        AdicionarPagamentoPresenter presenter = new AdicionarPagamentoPresenter();
    }
    
    private void goToListarPagamentos() {
        ListarPagamentosPresenter presenter = new ListarPagamentosPresenter();
    }
    
    private void goToExportarDados() {
        SalvarDados.exportar();
    }
    
    private void goToImportarDados() {
        SalvarDados.importar();
    }

    private void goToConfigSistema() {
        ConfigurarSistemaPresenter presenter = new ConfigurarSistemaPresenter();
    }
}
