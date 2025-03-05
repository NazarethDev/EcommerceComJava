package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.adress.NewAdress;
import br.com.nazareth.Catalogo.service.AdressService;
import br.com.nazareth.Catalogo.service.user.UsuarioDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping
    public ResponseEntity addAdress (@AuthenticationPrincipal UsuarioDetailsImpl userDetails, @RequestBody NewAdress dados){
        Long userId = userDetails.getId();
        return adressService.novoEndereco(dados, userId);
    }
}