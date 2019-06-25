/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

/**
 *
 * @author breno
 */
public class DiretorGeralAutorizadora extends AutorizadoraPagamento {

    @Override
    public boolean autorizar(Pagamento pagamento) {
        return (pagamento.getValor() <= 15000);
    }
    
    @Override
    public String getNomeAutorizadora() {
        return "Diretor Geral";
    }
}
