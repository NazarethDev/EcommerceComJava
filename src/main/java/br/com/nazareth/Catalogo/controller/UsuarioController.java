package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.model.user.DadosCadastro;
import br.com.nazareth.Catalogo.service.user.UsuarioDetailsImpl;
import br.com.nazareth.Catalogo.service.user.UsuarioService;
import jakarta.validation.Valid;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @PostMapping("/newuser")
    public ResponseEntity<?> setUser(@RequestBody @Valid DadosCadastro dados) {
        return userService.newUser(dados);
    }

    @PostMapping("/newadim")
    public ResponseEntity<?> setAdmin(@RequestBody @Valid DadosCadastro dados) {
        return userService.newAdmin(dados);
    }

    @GetMapping("/mycoments")
    public ResponseEntity showUserComents (@AuthenticationPrincipal UsuarioDetailsImpl userDetails){
        return userService.showComents(userDetails.getId());
    }
}