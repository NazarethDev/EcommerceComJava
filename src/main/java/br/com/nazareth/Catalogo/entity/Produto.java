package br.com.nazareth.Catalogo.entity;

import br.com.nazareth.Catalogo.model.product.CategoriaProduto;
import br.com.nazareth.Catalogo.model.product.ProductData;
import br.com.nazareth.Catalogo.model.product.ProductDataFood;
import br.com.nazareth.Catalogo.model.product.TipoAlimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double precoParaVenda;
    private double precoCompra;

    @DateTimeFormat(pattern =  "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;

    @OneToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Comentarios> comentarios;
    private double avaliacao;

    @Enumerated(EnumType.STRING)
    private TipoAlimento tipoAlimento;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;

    private int quant;


    public Produto (ProductData newProductData){
        this.nome = newProductData.productName();
        this.descricao = newProductData.description();
        this.precoParaVenda = newProductData.precoParaVenda();
        this.precoCompra = newProductData.precoCompra();
        this.quant = newProductData.quant();
        this.categoriaProduto = newProductData.categoriaProduto();
    }

    public Produto (){}

    public Produto (ProductDataFood newProductData){
        this.nome = newProductData.productName();
        this.descricao = newProductData.description();
        this.precoCompra = newProductData.precoCompra();
        this.precoParaVenda = newProductData.precoParaVenda();
        this.dataValidade = newProductData.dataValidade();
        this.tipoAlimento = newProductData.tipoAlimento();
        this.quant = newProductData.quant();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoParaVenda() {
        return precoParaVenda;
    }

    public void setPrecoParaVenda(double precoParaVenda) {
        this.precoParaVenda = precoParaVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}