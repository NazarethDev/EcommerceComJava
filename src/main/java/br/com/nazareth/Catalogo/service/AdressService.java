package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Endereco;
import br.com.nazareth.Catalogo.model.adress.NewAdress;
import br.com.nazareth.Catalogo.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public ResponseEntity newAdress (NewAdress novoEndereco){
        Endereco adress = new Endereco(novoEndereco);
        adressRepository.save(adress);
        return ResponseEntity.ok(new NewAdress(adress));
    }

//    public ResponseEntity updateAdress

}
