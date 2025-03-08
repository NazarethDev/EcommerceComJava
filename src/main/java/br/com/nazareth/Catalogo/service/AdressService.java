package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Endereco;
import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.adress.DadosEndereco;
import br.com.nazareth.Catalogo.model.adress.NewAdress;
import br.com.nazareth.Catalogo.repository.AdressRepository;
import br.com.nazareth.Catalogo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private UsuarioRepository userRepository;

    public boolean verifyAdress(Long id){
        return adressRepository.existsById(id);
    }

    //cria um novo endereco
    public ResponseEntity novoEndereco(NewAdress dados, Long userId){
        Usuario usuario = userRepository.findById(userId).get();
        Endereco endereco = new Endereco(dados, usuario);
        return ResponseEntity.ok(new NewAdress(endereco));
    }

    //mostrar enderecos de entrega ou faturação. No parâmentro de busca, use true para endereços de entrega e false para endereços de faturação.
    public ResponseEntity<List<DadosEndereco>> showAdresses(Long userId, boolean isEntrega){
        List<Endereco> enderecos = adressRepository.searchAdress(userId, isEntrega);

        if (enderecos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<DadosEndereco> dadosEnderecos = enderecos.stream()
                .map(DadosEndereco::new).toList();
        return ResponseEntity.ok(dadosEnderecos);
    }

    //deletar endereço
    public ResponseEntity deleteAdress(Long id){
        if (!verifyAdress(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        adressRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //atualizar endereço
    public ResponseEntity updateAdress(Long id, DadosEndereco dados){
        if(!verifyAdress(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var endereco = adressRepository.findById(id).get();
        endereco.update(dados);
        adressRepository.save(endereco);
        return ResponseEntity.ok(new DadosEndereco(endereco));
    }

}
