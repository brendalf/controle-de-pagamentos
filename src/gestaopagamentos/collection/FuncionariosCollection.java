/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.collection;

import gestaopagamentos.business.Funcionario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class FuncionariosCollection implements Serializable {
    
    private ArrayList<Funcionario> funcionarios;
    private static FuncionariosCollection instance;
    
    public static FuncionariosCollection getInstance(){
        if(instance == null){
            instance = new FuncionariosCollection();
        }
        return instance;
    }

    public FuncionariosCollection() {
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
}
