package br.com.nazareth.Catalogo.model.user;

import br.com.nazareth.Catalogo.entity.Usuario;

public record DadosUsuario(
        Long id,
        String nome,
        String email,
        int cpf,
        int telefone
) {
    public DadosUsuario (Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getCpf(), usuario.getTelefone());
    }
}
