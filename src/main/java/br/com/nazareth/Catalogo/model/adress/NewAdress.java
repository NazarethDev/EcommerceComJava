package br.com.nazareth.Catalogo.model.adress;

import br.com.nazareth.Catalogo.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewAdress(
        @NotBlank
        String logradouro,
        @NotBlank
        int numeroDaCasa,
        String complemento,
        @NotBlank
        int cep,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String pais,
        @NotNull
        TipoEndereco tipoEndereco,
        @NotNull
        int telefone
) {
    public NewAdress (Endereco endereco){
        this(endereco.getLogradouro(), endereco.getNumeroDaCasa(),
                endereco.getComplemento(), endereco.getCep(), endereco.getCidade(),
                endereco.getEstado(), endereco.getPais(), endereco.getTipo(),endereco.getTelefone());
    }
}
