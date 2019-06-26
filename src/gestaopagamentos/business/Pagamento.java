/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.business;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author breno
 */
public class Pagamento implements Serializable {    
    private double valor;
    private Date dataVencimento;
    private Date dataPagamento;
    private String descricao;
    private Funcionario solicitante;
    private Funcionario aprovador;
    private ArrayList<DetalhePagamento> detalhes;

    private Pagamento() {
        
    }

    public Pagamento(double valor, Date dataVencimento, String descricao, Funcionario solicitante) throws Exception {
        if(descricao == null || descricao.trim().isEmpty()) {
            throw new Exception("Descricao invalida");
        } else if(solicitante == null) {
            throw new Exception("Solicitante invalido");
        } else if(dataVencimento == null) {
            throw new Exception("Data de vencimento invalida");
        } else if(valor <= 0) {
            throw new Exception("Valor invalido");
        }
        
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.detalhes = new ArrayList<>();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
    }

    public ArrayList<DetalhePagamento> getDetalhes() {
        return detalhes;
    }

    public void addDetalhe(String descricao, String usuario) {
        this.detalhes.add(new DetalhePagamento(Date.from(Instant.now()), descricao, usuario));
    }

    public Funcionario getAprovador() {
        return aprovador;
    }

    public void setAprovador(Funcionario aprovador) {
        this.aprovador = aprovador;
    }

    public String getSituacao() {
        if(this.aprovador != null) {
            return "Aprovado"; 
        }
        
        if(this.dataVencimento.after(new Date())) {
            return "Aguardando";
        }
        
        return "Rejeitado";
    }
}
