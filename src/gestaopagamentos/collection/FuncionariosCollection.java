/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.collection;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.observer.IObserver;
import gestaopagamentos.observer.ISubject;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class FuncionariosCollection implements Serializable, ISubject {
    
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<IObserver> observers;
    private static FuncionariosCollection instance;
    
    public static FuncionariosCollection getInstance(){
        if(instance == null){
            instance = new FuncionariosCollection();
        }
        return instance;
    }

    public FuncionariosCollection() {
        this.funcionarios = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
        notifyObservers();
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
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
