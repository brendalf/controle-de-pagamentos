/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

import gestaopagamentos.collection.AutorizadoresCollection;
import gestaopagamentos.collection.UsuarioLogado;
import java.util.Date;

/**
 *
 * @author breno
 */
public class ProcessadoraPagamento {

    public ProcessadoraPagamento() {
        
    }
    
    public boolean processar(Pagamento pagamento) {
        Date data = new Date();
        
        if(pagamento.getDataVencimento().after(data)) {
            for(IAutorizadoraPagamento autorizadora : AutorizadoresCollection.getInstance().getAutorizadores())
                if(autorizadora.isMetodoHabilitado())
                    if(autorizadora.autorizar(pagamento))
                        return true;
            
            pagamento.addDetalhe("Nenhum funcionario pode aprovar", UsuarioLogado.getInstance().getUsuario().getUser());
        } else {
            pagamento.addDetalhe("Pagamento vencido", UsuarioLogado.getInstance().getUsuario().getUser());
        }
        
        return false;
    }
}
