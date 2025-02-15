package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {

    @Autowired
    private ComentariosRepository comentRepository;
}
