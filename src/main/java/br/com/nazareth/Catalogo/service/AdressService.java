package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Endereco;
import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.adress.NewAdress;
import br.com.nazareth.Catalogo.repository.AdressRepository;
import br.com.nazareth.Catalogo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private UsuarioRepository userRepository;

    //cria um novo endereco
    public ResponseEntity novoEndereco(NewAdress dados, Long userId){
        Usuario usuario = userRepository.findById(userId).get();
        Endereco endereco = new Endereco(dados, usuario);
        return ResponseEntity.ok(new NewAdress(endereco));
    }

    //mostrar enderecos de entrega
    public ResponseEntity enderecosEntrega(){
        adressRepository.findEnderecoByEnderecoEntregaIsTrue();
        return ResponseEntity.ok().build();
    }

}
