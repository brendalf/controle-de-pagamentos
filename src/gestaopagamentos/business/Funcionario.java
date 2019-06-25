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
    private int numeroFaltas;
    
    private Funcionario() {
        
    }

    public Funcionario(String nome, String cargo, int idade) throws Exception {
        if(nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome invalido");
        } else if(cargo == null || cargo.trim().isEmpty()) {
            throw new Exception("Cargo invalido");
        } else if(idade <= 0) {
            throw new Exception("Idade invalida");
        }
        
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.numeroFaltas = 0;
    }

    public Funcionario(String nome, String cargo, int idade, int numeroFaltas) throws Exception {
        this(nome, cargo, idade);
        
        if(numeroFaltas < 0) {
            throw new Exception("Faltas invalida");
        }

        this.numeroFaltas = numeroFaltas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNumeroFaltas() {
        return numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }
}
