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
public class DiretorFinanceiroAutorizadora extends IAutorizadoraPagamento {

    @Override
    public boolean autorizar(Pagamento pagamento) {
        return (pagamento.getValor() <= 5000);     
    }

    @Override
    public String getNomeAutorizadora() {
        return "Diretor Financeiro";
    }
}
