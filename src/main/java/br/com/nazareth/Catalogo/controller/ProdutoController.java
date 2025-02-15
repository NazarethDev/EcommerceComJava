package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    private ProdutoService productService;
}
