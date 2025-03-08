package br.com.nazareth.Catalogo.model.coment;

import br.com.nazareth.Catalogo.entity.Comentarios;
import br.com.nazareth.Catalogo.entity.Usuario;

import java.time.LocalDate;

public record ComentarioGerado (
        Long id,
        String mensgem,
        LocalDate dataCriacao
){
    public ComentarioGerado (Comentarios comentarios){
        this(comentarios.getId(), comentarios.getMensagem(),
                comentarios.getDataCriacao());
    }
}
