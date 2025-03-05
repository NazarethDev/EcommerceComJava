package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.model.user.DadosCadastro;
import br.com.nazareth.Catalogo.service.user.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @PostMapping("/newuser")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastro dados) {
        return userService.newUser(dados);
    }

    @PostMapping("/newadim")
    public ResponseEntity<?> setAdmin(@RequestBody @Valid DadosCadastro dados) {
        return userService.newAdmin(dados);
    }
}