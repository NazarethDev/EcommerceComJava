package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository adressRepository;
}
