/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.presenter;

import gestaopagamentos.collection.PagamentosCollection;
import gestaopagamentos.collection.UsuarioLogado;
import gestaopagamentos.observer.IObserver;
import gestaopagamentos.persistence.ImportarFuncionariosCSV;
import gestaopagamentos.persistence.SalvarDados;
import gestaopagamentos.view.HomeView;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author breno
 */
public class HomePresenter implements IObserver {
    
    private HomeView view;
    
    public HomePresenter() {
        this.view = new HomeView();
        this.view.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.view.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.view.getHeight()/ 2));
        this.view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                PagamentosCollection.getInstance().removeObserver(HomePresenter.this);
            }            
        });
        this.view.setVisible(true);
        this.view.setTitle("Sistema de Gestão de Pagamentos");
        
        this.view.getTxtNomeUsuarioLogado().setText(UsuarioLogado.getInstance().getUsuario().getFuncionario().getNome());
        this.view.getTxtCargoUsuarioLogado().setText(UsuarioLogado.getInstance().getUsuario().getFuncionario().getCargo());
        
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
        
        this.view.getMenuImportarFuncionarios().addActionListener((ActionEvent e) -> {
            goToImportarFuncionarios();
        });
        
        showPagamentos();
        
        PagamentosCollection.getInstance().registerObserver(this);
    }
    
    private void goToListarFuncionarios() {
        ListarFuncionariosPresenter presenter = new ListarFuncionariosPresenter();
    }

    private void goToAddFuncionario() {
        ManterFuncionarioPresenter presenter = new ManterFuncionarioPresenter();
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

    private void goToImportarFuncionarios() {
        ImportarFuncionariosCSV.importar();
    }

    @Override
    public void update() {
        showPagamentos();
    }

    private void showPagamentos() {
        this.view.getTxtPagamentosRegistrados().setText(String.valueOf(PagamentosCollection.getInstance().getPagamentos().size()));
    }
}
