package br.com.nazareth.Catalogo.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double procentagemDesconto;

    @OneToMany(mappedBy = "promocao")
    private List <Pedido> pedidos;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate expiraEm;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;

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

    public double getProcentagemDesconto() {
        return procentagemDesconto;
    }

    public void setProcentagemDesconto(double procentagemDesconto) {
        this.procentagemDesconto = procentagemDesconto;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public LocalDate getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(LocalDate expiraEm) {
        this.expiraEm = expiraEm;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }
}
