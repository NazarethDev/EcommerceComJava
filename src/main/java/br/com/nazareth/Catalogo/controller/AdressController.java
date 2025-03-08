package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.model.adress.DadosEndereco;
import br.com.nazareth.Catalogo.model.adress.NewAdress;
import br.com.nazareth.Catalogo.service.AdressService;
import br.com.nazareth.Catalogo.service.user.UsuarioDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping
    public ResponseEntity addAdress (@AuthenticationPrincipal UsuarioDetailsImpl userDetails, @RequestBody NewAdress dados){
        return adressService.novoEndereco(dados, userDetails.getId());
    }

    @GetMapping
    public ResponseEntity showAdress(@AuthenticationPrincipal UsuarioDetailsImpl userDetails, @RequestParam boolean isEntrega){
        return adressService.showAdresses(userDetails.getId(),isEntrega);
    }

    @DeleteMapping
    public ResponseEntity deleteAdress (@PathVariable Long adressId){
        return adressService.deleteAdress(adressId);
    }

    @PutMapping
    public ResponseEntity updateAdress(@PathVariable Long id, @RequestBody DadosEndereco dados){
        return adressService.updateAdress(id, dados);
    }
}