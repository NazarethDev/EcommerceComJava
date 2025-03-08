package br.com.nazareth.Catalogo.model.adress;

import br.com.nazareth.Catalogo.entity.Endereco;
import br.com.nazareth.Catalogo.entity.Usuario;

public record UpdateAdress (
        Long id,
        String logradouro,
        int numeroDaCasa,
        String complemento,
        String cidade,
        String estado,
        String pais,
        int telefone,
        Usuario usuario
) {
    public UpdateAdress(Endereco endereco){
        this(endereco.getId(), endereco.getLogradouro(), endereco.getNumeroDaCasa(),
                endereco.getComplemento(), endereco.getCidade(), endereco.getEstado(),
                endereco.getPais(), endereco.getTelefone(), endereco.getUsuario());
    }
}
