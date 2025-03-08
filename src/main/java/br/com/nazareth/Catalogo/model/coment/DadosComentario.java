package br.com.nazareth.Catalogo.model.coment;

import br.com.nazareth.Catalogo.entity.Comentarios;

import java.time.LocalDate;

public record DadosComentario(
        Long id,
        String mensagem,
        LocalDate dataCriacao,
        LocalDate dataAtualizacao

) {
    public DadosComentario(Comentarios comentarios){
        this(comentarios.getId(), comentarios.getMensagem(),
                comentarios.getDataCriacao(), comentarios.getDataAtualizacao());
    }
}