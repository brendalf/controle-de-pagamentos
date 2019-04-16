/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.business;

/**
 *
 * @author breno
 */
public class Funcionario {
    private String nome;
    private String cargo;
    private int idade;
    private int numeroFaltas;
    
    private Funcionario() {
        
    }

    public Funcionario(String nome, String cargo, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.numeroFaltas = 0;
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
