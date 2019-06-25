/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

/**
 *
 * @author Aluno
 */
public class EmergencialAutorizadora extends AutorizadoraPagamento {   

    @Override
    public boolean autorizar(Pagamento pagamento) {
        return (pagamento.getDescricao().contains("Emergencial"));
    }
    
    @Override
    public String getNomeAutorizadora() {
        return "Emergencial";
    }
}
