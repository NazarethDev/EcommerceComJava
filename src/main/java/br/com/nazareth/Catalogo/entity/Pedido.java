package br.com.nazareth.Catalogo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Usuario cliente;

    @ManyToMany
    @JsonIgnore
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "endereco_entega_id")
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn(name = "endereco_faturacao_id")
    private Endereco enderecoFaturacao;
    private double valorTotal;
    private double valorEntrega;
    private double valorProdutos;

    @ManyToOne
    @JoinColumn(name = "promocao_id")
    private Promocao promocao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(double valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    public double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Endereco getEnderecoFaturacao() {
        return enderecoFaturacao;
    }

    public void setEnderecoFaturacao(Endereco enderecoFaturacao) {
        this.enderecoFaturacao = enderecoFaturacao;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }
}
