/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.business;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author breno
 */
public class Pagamento {
    private double valor;
    private Date dataVencimento;
    private Date dataPagamento;
    private String descricao;
    private Funcionario solicitante;
    private Funcionario aprovador;
    private ArrayList<DetalhePagamento> detalhes;

    private Pagamento() {
        
    }

    public Pagamento(double valor, Date dataVencimento, String descricao, Funcionario solicitante) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.detalhes = new ArrayList<>();
        addDetalhe("Pagamento gerado!", "Sistema");
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        addDetalhe("Valor alterado!", "Sistema");
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
        addDetalhe("Data de vencimento alterada!", "Sistema");
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
        addDetalhe("Data de pagamento alterada!", "Sistema");
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        addDetalhe("Descrição alterada!", "Sistema");
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
        addDetalhe("Solicitante alterado!", "Sistema");
    }

    public ArrayList<DetalhePagamento> getDetalhes() {
        return detalhes;
    }

    public void addDetalhe(String descricao, String usuario) {
        this.detalhes.add(new DetalhePagamento(Date.from(Instant.now()), descricao, usuario));
    }
}
