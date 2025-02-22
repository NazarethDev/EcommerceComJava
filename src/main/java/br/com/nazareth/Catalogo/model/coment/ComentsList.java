package br.com.nazareth.Catalogo.model.coment;

import br.com.nazareth.Catalogo.entity.Comentarios;
import br.com.nazareth.Catalogo.entity.Usuario;

import java.time.LocalDate;

public record ComentsList(
        Long id,
        String mensegem,
        Usuario autor,
        LocalDate dataCriacao,
        LocalDate dataAtualizacao
) {
    public ComentsList(Comentarios comentarios){
        this(comentarios.getId(), comentarios.getMensagem(),
                comentarios.getAutor(), comentarios.getDataCriacao(),
                comentarios.getDataAtualizacao());
    }
}
