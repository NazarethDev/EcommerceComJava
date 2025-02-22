package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Comentarios;
import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.coment.ComentarioGerado;
import br.com.nazareth.Catalogo.model.coment.NewComent;
import br.com.nazareth.Catalogo.repository.ComentariosRepository;
import br.com.nazareth.Catalogo.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {

    @Autowired
    private ComentariosRepository comentRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity newComent(NewComent dados, Usuario usuario){
        var produto = produtoRepository.findById(dados.productId())
                .orElseThrow(()->new EntityNotFoundException("Produto não encontrado :("));
        var comentario = new Comentarios(dados, usuario, produto);
        produto.getComentarios().add(comentario);
        comentRepository.save(comentario);
        return ResponseEntity.ok(new ComentarioGerado(comentario));
    }

}
