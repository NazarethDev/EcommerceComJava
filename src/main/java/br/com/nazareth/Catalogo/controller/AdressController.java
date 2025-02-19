package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;
}
