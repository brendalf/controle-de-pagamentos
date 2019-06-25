/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos;

import gestaopagamentos.business.AutorizadoraPagamento;
import gestaopagamentos.business.DiretorFinanceiroAutorizadora;
import gestaopagamentos.business.DiretorGeralAutorizadora;
import gestaopagamentos.business.EmergencialAutorizadora;
import gestaopagamentos.business.Funcionario;
import gestaopagamentos.business.GerenteGeralAutorizadora;
import gestaopagamentos.business.GerenteImediatoAutorizadora;
import gestaopagamentos.business.Pagamento;
import gestaopagamentos.business.ProcessadoraPagamento;
import gestaopagamentos.presenter.HomePresenter;
import gestaopagamentos.presenter.LoginPresenter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author breno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Funcionario f1 = new Funcionario("Funcionario 1", "Cargo 1", 20);
//        Funcionario f2 = new Funcionario("Funcionario 2", "Cargo 2", 30);
//        
//        AutorizadoraPagamento emergencial = new EmergencialAutorizadora();
//        AutorizadoraPagamento gerenteImediato = new GerenteImediatoAutorizadora();
//        AutorizadoraPagamento gerenteGeral = new GerenteGeralAutorizadora();
//        AutorizadoraPagamento diretorFinanceiro = new DiretorFinanceiroAutorizadora();
//        AutorizadoraPagamento diretorGeral = new DiretorGeralAutorizadora();
//        
//        ProcessadoraPagamento processadora = new ProcessadoraPagamento();
//        processadora.addAutorizador(emergencial);
//        processadora.addAutorizador(gerenteImediato);
//        processadora.addAutorizador(gerenteGeral);
//        processadora.addAutorizador(diretorFinanceiro);
//        processadora.addAutorizador(diretorGeral);
//
//        ArrayList<Pagamento> pagamentos = new ArrayList<>();
//        for(int i = 0; i < 100; i++) {
//            long dataVencimento = System.currentTimeMillis();
//            if(Math.random() * 10 <= 2) dataVencimento -= 10000;
//            
//            processadora.processar(new Pagamento(Math.random() * 20000, new Date(dataVencimento), "Pagamento " + i + ((Math.random() * 10 <= 3) ? " Emergencial" : ""), (Math.random() * 10 <= 5) ? f1 : f2));
//        }
        HomePresenter homePresenter = new HomePresenter();
    }
    
}