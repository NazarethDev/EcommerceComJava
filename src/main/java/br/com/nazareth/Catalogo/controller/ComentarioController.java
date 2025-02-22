package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.coment.NewComent;
import br.com.nazareth.Catalogo.service.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coment")
public class ComentarioController {

    @Autowired
    private ComentariosService comentService;

    @PostMapping
    public ResponseEntity novoComentario(@RequestBody NewComent dados, @AuthenticationPrincipal Usuario autor){
        return comentService.newComent(dados, autor);
    }

    @GetMapping
    private ResponseEntity showProductComents(@PathVariable Long productId){
        return comentService.showComents(productId);
    }

    //deleta um comentário
    @DeleteMapping
    public ResponseEntity deleteComent(@PathVariable Long id, @AuthenticationPrincipal Usuario autor){
        return comentService.deleteComent(id, autor);
    }
}
