/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class ProcessadoraPagamento {
    private ArrayList<IAutorizadoraPagamento> autorizadores;

    public ProcessadoraPagamento() {
        this.autorizadores = new ArrayList<>();
    }

    public ProcessadoraPagamento(ArrayList<IAutorizadoraPagamento> autorizadores) {
        this.autorizadores = autorizadores;
    }  
    
    public void addAutorizador(IAutorizadoraPagamento autorizadora) {
        this.autorizadores.add(autorizadora);
    }   
    
    public boolean processar(Pagamento pagamento) {
        for(IAutorizadoraPagamento autorizadora : this.autorizadores) {
            if(autorizadora.isMetodoHabilitado()) {
                if(autorizadora.autorizar(pagamento)) {
                    System.out.println(pagamento.toString() + " aprovado por " + autorizadora.toString());
                    pagamento.addDetalhe("Pagamento aprovado por " + autorizadora.toString(), "Sistema");
                    return true;
                } else {
                    pagamento.addDetalhe(autorizadora.toString() + " não pode aprovar!", "Sistema");
                }                
            } else {
                pagamento.addDetalhe(autorizadora.toString() + " não habilitado!", "Sistema");
            }
        }
        
        pagamento.addDetalhe("Pagamento não aprovado!", "Sistema");
        return false;
    }
}
