package br.com.nazareth.Catalogo.entity;

import br.com.nazareth.Catalogo.model.coment.AtualizaComentario;
import br.com.nazareth.Catalogo.model.coment.NewComent;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Comentarios {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto produto;

    @DateTimeFormat(pattern =  "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao, dataAtualizacao;

    public Comentarios(NewComent comentario, Usuario autor, Produto produto){
        this.produto = produto;
        this.autor = autor;
        this.mensagem = comentario.mensagem();
        this.dataCriacao = LocalDate.now();
    }

    public void atualizarComentario(AtualizaComentario dados){
        this.mensagem = dados.mensagem();
        this.dataAtualizacao = LocalDate.now();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
