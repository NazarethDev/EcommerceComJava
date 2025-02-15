package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository userService;
}