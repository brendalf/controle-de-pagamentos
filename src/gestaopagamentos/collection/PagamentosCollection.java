/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.collection;

import gestaopagamentos.business.Pagamento;
import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class PagamentosCollection {
    
    private ArrayList<Pagamento> pagamentos;
    private static PagamentosCollection instance;
    
    public static PagamentosCollection getInstance(){
        if(instance == null){
            instance = new PagamentosCollection();
        }
        return instance;
    }
    
    private PagamentosCollection() {
        this.pagamentos = new ArrayList<>();
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void addPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }
}
