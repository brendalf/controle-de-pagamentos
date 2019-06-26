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
 * @author Aluno
 */
public class EmergencialAutorizadora extends IAutorizadoraPagamento {   

    @Override
    public boolean autorizar(Pagamento pagamento) {
        if(pagamento.getDescricao().contains("emergencial") || pagamento.getDescricao().contains("Emergencial")) {
            ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) FuncionariosCollection.getInstance().getFuncionarios().clone();
            Collections.shuffle(funcionarios);

            for(Funcionario funcionario : funcionarios) {
                if(funcionario.getFaltas()<= 15) {
                    pagamento.addDetalhe("Aprovado pelo " + getNomeAutorizadora(), UsuarioLogado.getInstance().getUsuario().getUser());
                    pagamento.setDataPagamento(new Date());
                    pagamento.setAprovador(funcionario);
                    return true;
                }
            }
        } else {
            pagamento.addDetalhe(getNomeAutorizadora() + " so aprova emergencial.", UsuarioLogado.getInstance().getUsuario().getUser());
        }
        
        return false;
    }
    
    @Override
    public String getNomeAutorizadora() {
        return "Emergencial";
    }
}
