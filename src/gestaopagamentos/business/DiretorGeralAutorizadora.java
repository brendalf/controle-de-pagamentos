/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.collection.UsuarioLogado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author breno
 */
public class DiretorGeralAutorizadora extends IAutorizadoraPagamento {

    @Override
    public boolean autorizar(Pagamento pagamento) {
        if(pagamento.getValor() >= 0 && pagamento.getValor() <= 15000) {
            if(!pagamento.getSolicitante().getCargo().equalsIgnoreCase(getNomeAutorizadora())) {
                ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) FuncionariosCollection.getInstance().getFuncionarios().clone();
                Collections.shuffle(funcionarios);
                
                for(Funcionario funcionario : funcionarios) {
                    if(funcionario.getCargo().equals(getNomeAutorizadora()) && funcionario.getFaltas()<= 15) {
                        pagamento.addDetalhe("Aprovado pelo " + getNomeAutorizadora(), UsuarioLogado.getInstance().getUsuario().getUser());
                        pagamento.setDataPagamento(new Date());
                        pagamento.setAprovador(funcionario);
                        return true;
                    }
                }                
            } else {
                pagamento.addDetalhe(getNomeAutorizadora() + " não aprova pagamento desse solicitante.", UsuarioLogado.getInstance().getUsuario().getUser());
            }
        } else {
            pagamento.addDetalhe(getNomeAutorizadora() + " não aprova esse valor.", UsuarioLogado.getInstance().getUsuario().getUser());
        }
        
        return false;
    }
    
    @Override
    public String getNomeAutorizadora() {
        return "Diretor Geral";
    }
}
