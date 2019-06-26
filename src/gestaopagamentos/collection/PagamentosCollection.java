/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.collection;

import gestaopagamentos.business.Pagamento;
import gestaopagamentos.observer.IObserver;
import gestaopagamentos.observer.ISubject;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class PagamentosCollection implements Serializable, ISubject {
    
    private ArrayList<Pagamento> pagamentos;
    private ArrayList<IObserver> observers;
    private static PagamentosCollection instance;
    
    public static PagamentosCollection getInstance(){
        if(instance == null){
            instance = new PagamentosCollection();
        }
        return instance;
    }
    
    private PagamentosCollection() {
        this.pagamentos = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
        notifyObservers();
    }

    public void addPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : this.observers) {
            observer.update();
        }
    }
}
