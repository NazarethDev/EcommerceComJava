package br.com.nazareth.Catalogo.entity;

import br.com.nazareth.Catalogo.model.adress.NewAdress;
import br.com.nazareth.Catalogo.model.adress.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipo;

    private String logradouro;
    private int numeroDaCasa;
    private String complemento;
    private int cep;
    private String cidade;
    private String estado;
    private String pais;
    private int telefone;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    public Endereco (NewAdress dadosEndereco){
        this.logradouro = dadosEndereco.logradouro();
        this.numeroDaCasa = dadosEndereco.numeroDaCasa();
        this.complemento = dadosEndereco.complemento();;
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.estado = dadosEndereco.estado();
        this.pais = dadosEndereco.pais();
        this.tipo = dadosEndereco.tipoEndereco();
        this.telefone = dadosEndereco.telefone();
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTelefone() {return telefone;}

    public void setTelefone(int telefone) {this.telefone = telefone;}
}
