package br.com.nazareth.Catalogo.service.user;

import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.coment.DadosComentario;
import br.com.nazareth.Catalogo.model.order.DadosDoPedido;
import br.com.nazareth.Catalogo.model.user.*;
import br.com.nazareth.Catalogo.repository.ComentariosRepository;
import br.com.nazareth.Catalogo.repository.PedidoRepository;
import br.com.nazareth.Catalogo.repository.UsuarioRepository;
import br.com.nazareth.Catalogo.service.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ComentariosRepository comentRepository;

    @Autowired
    private PedidoRepository orderRepository;

    public ResponseEntity entrar (@Valid DadosAutenticacao dados){
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.ok(new JWTTokenDates(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity newUser (DadosCadastro dados){
        var novoUsuario = new Usuario();
        novoUsuario.setNome(dados.nome());
        novoUsuario.setEmail(dados.email());
        novoUsuario.setSenha(passwordEncoder.encode(dados.senha()));
        novoUsuario.setRole(Role.CLIENTE);
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }

    public ResponseEntity newAdmin (DadosCadastro dados){
        var novoUsuario = new Usuario();
        novoUsuario.setNome(dados.nome());
        novoUsuario.setEmail(dados.email());
        novoUsuario.setSenha(passwordEncoder.encode(dados.senha()));
        novoUsuario.setRole(Role.ADMIN);
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Administrador cadastrado com sucesso!");
    }

    //mostra comentários do usuário
    public ResponseEntity showComents (Long autorId){
        var comentarios = comentRepository.findComentarioByAutorId(autorId);
        if (comentarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<DadosComentario> listaComentarios = comentarios.stream()
                .map(DadosComentario::new).toList();
        return ResponseEntity.ok(listaComentarios);
    }

    //mostra dados do usuário
    public ResponseEntity showUserDates(Long userId){
        var user = usuarioRepository.findById(userId);
        if (user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var usuario = user.get();
        return ResponseEntity.ok(new DadosUsuario(usuario));
    }

    //lista de pedidos
    public ResponseEntity orderHistoty (Long userId){
        var pedidos = orderRepository.findByClienteId(userId);
        if (pedidos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<DadosDoPedido> listaPedidos = pedidos.stream()
                .map(DadosDoPedido::new).toList();
        return ResponseEntity.ok(listaPedidos);
    }
}