/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.business;

/**
 *
 * @author breno
 */
public class GerenteGeralAutorizadora extends AutorizadoraPagamento {   

    @Override
    public boolean autorizar(Pagamento pagamento) {
        return (pagamento.getValor() <= 1500);
    }
}
