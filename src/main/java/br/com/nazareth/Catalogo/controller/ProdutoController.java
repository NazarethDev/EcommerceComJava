package br.com.nazareth.Catalogo.controller;

import br.com.nazareth.Catalogo.model.product.ProductData;
import br.com.nazareth.Catalogo.model.product.ProductDataFood;
import br.com.nazareth.Catalogo.model.product.UpdateProduct;
import br.com.nazareth.Catalogo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    private ProdutoService productService;

    @GetMapping("/productdetails/{id}")
    public ResponseEntity showDetails (@PathVariable Long id){
        return productService.showProductDetails(id);
    }

    @GetMapping("findByCategory")
    public ResponseEntity findByCategory (@RequestParam String categoria){
        return productService.searchByCategory(categoria);
    }

    @PostMapping("/createProduct")
    public ResponseEntity createProduct (@RequestBody ProductData dados){
        return productService.newProduct(dados);
    }

    @PostMapping("/newfood")
    public ResponseEntity newfood (@RequestBody ProductDataFood dados){
        return productService.newFood(dados);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct (@PathVariable Long id, @RequestBody UpdateProduct dados){
        return productService.updateProduct(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct (@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
