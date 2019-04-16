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
public abstract class AutorizadoraPagamento {
    private boolean metodoHabilitado;

    public AutorizadoraPagamento() {
        this.metodoHabilitado = true;
    }
    
    public AutorizadoraPagamento(boolean metodoHabilitado) {
        this.metodoHabilitado = metodoHabilitado;
    }

    public boolean isMetodoHabilitado() {
        return metodoHabilitado;
    }

    public void setMetodoHabilitado(boolean metodoHabilitado) {
        this.metodoHabilitado = metodoHabilitado;
    }
    
    public abstract boolean autorizar(Pagamento pagamento);
}
