/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.collection;

import gestaopagamentos.business.IAutorizadoraPagamento;
import gestaopagamentos.business.DiretorFinanceiroAutorizadora;
import gestaopagamentos.business.DiretorGeralAutorizadora;
import gestaopagamentos.business.EmergencialAutorizadora;
import gestaopagamentos.business.GerenteGeralAutorizadora;
import gestaopagamentos.business.GerenteImediatoAutorizadora;
import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class AutorizadoresCollection {
    
    private ArrayList<IAutorizadoraPagamento> autorizadores;
    private static AutorizadoresCollection instance;
    
    public static AutorizadoresCollection getInstance(){
        if(instance == null){
            instance = new AutorizadoresCollection();
        }
        return instance;
    }
    
    private AutorizadoresCollection(){  
        this.autorizadores = new ArrayList<>();
        this.autorizadores.add(new GerenteImediatoAutorizadora());
        this.autorizadores.add(new GerenteGeralAutorizadora());
        this.autorizadores.add(new DiretorFinanceiroAutorizadora());
        this.autorizadores.add(new DiretorGeralAutorizadora());
        this.autorizadores.add(new EmergencialAutorizadora());
    }
    
    public ArrayList<IAutorizadoraPagamento> getAutorizadores() {
        return autorizadores;
    }

    public void setAutorizadores(ArrayList<IAutorizadoraPagamento> autorizadores) {
        this.autorizadores = autorizadores;
    }
}
