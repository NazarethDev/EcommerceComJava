package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.coment.NewComent;
import br.com.nazareth.Catalogo.service.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coment")
public class ComentarioController {

    @Autowired
    private ComentariosService comentService;

    @PostMapping
    public ResponseEntity novoComentario(@RequestBody NewComent dados, @AuthenticationPrincipal Usuario autor){
        return comentService.newComent(dados, autor);
    }
}
