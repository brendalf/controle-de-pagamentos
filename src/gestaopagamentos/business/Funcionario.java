/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

import java.io.Serializable;

/**
 *
 * @author breno
 */
public class Funcionario implements Serializable {
    private String nome;
    private String cargo;
    private int idade;
    private int faltas;
    
    private Funcionario() {
        
    }

    public Funcionario(String nome, String cargo, int idade) throws Exception {        
        this.setNome(nome);
        this.setCargo(cargo);
        this.setIdade(idade);
        this.setFaltas(0);
    }

    public Funcionario(String nome, String cargo, int idade, int faltas) throws Exception {
        this.setNome(nome);
        this.setCargo(cargo);
        this.setIdade(idade);
        this.setFaltas(faltas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome invalido");
        }
        
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception {
        if(cargo == null || cargo.trim().isEmpty()) {
            throw new Exception("Cargo invalido");
        }
        
        this.cargo = cargo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws Exception {
        if(idade <= 0) {
            throw new Exception("Idade invalida");
        }
        
        this.idade = idade;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) throws Exception {
        if(faltas < 0) {
            throw new Exception("Numero de faltas invalido");
        }
        
        this.faltas = faltas;
    }
}
