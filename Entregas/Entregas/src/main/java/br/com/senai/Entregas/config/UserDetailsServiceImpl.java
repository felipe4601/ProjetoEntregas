package br.com.senai.Entregas.config;

import br.com.senai.Entregas.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //Injeção de dependência
    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Vamos explicar ao security como ele irá chegar até o email
        // Este é o único método que precisamos implementar.
        // O Spring Security o chama automaticamente durante o processo de autenticação,
        // passando o 'username' que o usuário forneceu na tela de login (que para nós, é o email).

        // 4. Usamos nosso repositório para buscar o usuário no banco de dados pelo email.
        return usuarioRepository.findByEmail(username)
                // 5. O método findByEmail retorna um 'Optional'. Se o Optional estiver vazio
                // (ou seja, o usuário não foi encontrado), o método .orElseThrow() é executado.
                // Ele lança uma exceção padrão do Spring Security, informando que o login falhou
                // porque o usuário não existe.
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        // 6. Se o usuário for encontrado, o objeto Usuario é retornado.
    }
}
