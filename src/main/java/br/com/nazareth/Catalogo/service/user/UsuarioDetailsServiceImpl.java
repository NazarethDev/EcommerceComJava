package br.com.nazareth.Catalogo.service.user;

import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class UsuarioDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

            if (usuario.isEmpty()) {
                throw new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email);
            }

            return new UsuarioDetailsImpl(usuario.get());
        }
    }
