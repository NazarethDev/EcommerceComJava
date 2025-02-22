package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Comentarios;
import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.coment.ComentarioGerado;
import br.com.nazareth.Catalogo.model.coment.ComentsList;
import br.com.nazareth.Catalogo.model.coment.NewComent;
import br.com.nazareth.Catalogo.repository.ComentariosRepository;
import br.com.nazareth.Catalogo.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {

    @Autowired
    private ComentariosRepository comentRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    //criar novo comentario
    public ResponseEntity newComent(NewComent dados, Usuario usuario){
        var produto = produtoRepository.findById(dados.productId())
                .orElseThrow(()->new EntityNotFoundException("Produto não encontrado :("));
        var comentario = new Comentarios(dados, usuario, produto);
        produto.getComentarios().add(comentario);
        comentRepository.save(comentario);
        return ResponseEntity.ok(new ComentarioGerado(comentario));
    }
    //mostrar comentarios por produto
    public ResponseEntity showComents(Long productId){
        if (!produtoRepository.existsById(productId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado. Verifique o ID e tente novamente.");
        }
        var comentarios = comentRepository.findByProdutoId(productId);
        comentarios.stream().map(ComentsList::new).toList();
        return ResponseEntity.ok(comentarios);
    }

    //deletar comentario
    public  ResponseEntity deleteComent(Long id, Usuario autor){
        var comentarioOpt = comentRepository.findById(id);
        if (comentarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Comentário não encontrado. Verifique o ID e tente novamente.");
        }
        var comentario = comentarioOpt.get();
        if (!comentario.getAutor().equals(autor) && !autor.getRole().equals("ADMIN")) {
            return ResponseEntity.status(HttpStatus.LOCKED)
                    .body("Apenas o usuário que criou o comentário pode excluí-lo.");
        }
        comentRepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }

}
