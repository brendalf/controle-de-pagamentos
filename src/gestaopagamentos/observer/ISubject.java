/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.observer;

/**
 *
 * @author breno
 */
public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();    
}
