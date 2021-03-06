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
public abstract class IAutorizadoraPagamento {
    private boolean metodoHabilitado;

    public IAutorizadoraPagamento() {
        this.metodoHabilitado = true;
    }
    
    public IAutorizadoraPagamento(boolean metodoHabilitado) {
        this.metodoHabilitado = metodoHabilitado;
    }
    
    public abstract String getNomeAutorizadora();

    public boolean isMetodoHabilitado() {
        return metodoHabilitado;
    }

    public void setMetodoHabilitado(boolean metodoHabilitado) {
        this.metodoHabilitado = metodoHabilitado;
    }
    
    public abstract boolean autorizar(Pagamento pagamento);
}
