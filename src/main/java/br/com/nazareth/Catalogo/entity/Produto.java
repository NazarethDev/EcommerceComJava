package br.com.nazareth.Catalogo.entity;

import br.com.nazareth.Catalogo.model.product.*;
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
    private Integer quant;
    private Boolean deleted = false;
    private Boolean alimento = false;

    @DateTimeFormat(pattern =  "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @DateTimeFormat(pattern =  "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedAt;



    public Produto (ProductData newProductData){
        this.nome = newProductData.productName();
        this.descricao = newProductData.description();
        this.precoParaVenda = newProductData.precoParaVenda();
        this.precoCompra = newProductData.precoCompra();
        this.quant = newProductData.quant();
        this.categoriaProduto = newProductData.categoriaProduto();
        this.createdAt = LocalDate.now();
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
        this.alimento = true;
        this.createdAt = LocalDate.now();
    }

    public void update(UpdateProduct dadosAtualizados) {
        if (dadosAtualizados.productName() != null) {
            this.nome = dadosAtualizados.productName();
        }
        if (dadosAtualizados.description() != null) {
            this.descricao = dadosAtualizados.description();
        }
        if (dadosAtualizados.precoParaVenda() != null) {
            this.precoParaVenda = dadosAtualizados.precoParaVenda();
        }
        if (dadosAtualizados.precoCompra() != null) {
            this.precoCompra = dadosAtualizados.precoCompra();
        }
        if (dadosAtualizados.dataValidade() != null) {
            this.dataValidade = dadosAtualizados.dataValidade();
        }
        if (dadosAtualizados.quant() != null) {
            this.quant = dadosAtualizados.quant();
        }
        if (dadosAtualizados.categoriaProduto() != null){
            this.categoriaProduto = dadosAtualizados.categoriaProduto();
        }
        if (dadosAtualizados.alimento() != null){
            this.alimento = dadosAtualizados.alimento();
        }
        this.updatedAt = LocalDate.now();
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

    public Integer getQuant() {
        return quant;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getAlimento() {
        return alimento;
    }

    public void setAlimento(Boolean alimento) {
        this.alimento = alimento;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id: " + id +
                ", nome: " + nome + '\'' +
                ", descrição: " + descricao + '\'' +
                ", Preço para venda: " + precoParaVenda +
                ", precoCompra=" + precoCompra +
                ", dataValidade=" + dataValidade +
                ", comentarios=" + comentarios +
                ", avaliacao=" + avaliacao +
                ", tipoAlimento=" + tipoAlimento +
                ", categoriaProduto=" + categoriaProduto +
                ", quant=" + quant +
                ", deleted=" + deleted +
                ", alimento=" + alimento +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}