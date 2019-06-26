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
public class GerenteGeralAutorizadora extends IAutorizadoraPagamento {   

    @Override
    public boolean autorizar(Pagamento pagamento) {
        return (pagamento.getValor() <= 1500);
    }
    
    @Override
    public String getNomeAutorizadora() {
        return "Gerente Geral";
    }
}
