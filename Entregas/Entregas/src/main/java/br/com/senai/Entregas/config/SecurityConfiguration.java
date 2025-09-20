package br.com.senai.Entregas.config;


import com.nimbusds.jose.jwk.source.ImmutableSecret;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

// Essa é a nossa central de comando, onde iremos definir tudo que será nessário para realizar o login
@Configuration
@EnableWebSecurity
// Essas anotações avisam ao spring que esta é uma classe de configuração de segurança
public class SecurityConfiguration {

    // Esse é o nosso token de segurança, nós definimos ele com uma string
    @Value("${api.jwt.secret}")
    private String jwtSecret;
    // Essa é a assinatura da nossa aplicação
    // @Bean são os controles da nossa segurança, que irão fazer o nosso login funcionar
    @Bean
    // 1. Gerador de tokens
    public JwtEncoder jwtEncoder(){
        // Cria a chave de criptografia a partir da nossa senha
        var secretKey = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA25HA256");
        // Retorna a implementação do codificador que usará nossa chave para assinar os tokens.
        return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey));
    }
    @Bean
    // 2. O Verificador de tokens(JWT DECODER)
    // Decodifica o jwt, ele lê o jwt encoder
    public JwtDecoder jwtDecoder(){
        // Criamos a mesma chave usada para codificar
        var secretKey = new SecretKeySpec(jwtSecret.getBytes(),"HmacSHA256");
        // Retorna a implementação do decodificador que usará a chave para verificar autenticidade dos tokens
        // Primeiro nós criamos o token e depois nós verificamos a sua autenticidade
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
        // Essa é a implementação do decodificador
    }

    @Bean
    // 3. CRIPTOGRAFADOR DE SENHAS
    public PasswordEncoder passwordEncoder(){
        // Retorna a implementação BCrypt, o padrão mais usado para criptografar
        // imagine que ele converte uma senha cadastrada em um código
        return new BCryptPasswordEncoder();
    }

    // 4. GERENTE DE AUTENTICAÇÃO
    @Bean
    public AuthenticationManager authenticatioManager(AuthenticationConfiguration config) throws Exception{
        // Pegamos um autenticador comum do spring, que já sabe usar
        // o UserDetailsService e PasswordEncoder para validar as credenciais de login.
        return config.getAuthenticationManager();

    }

    // FILTRO DE SENGURANÇA

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desativa a proteção CSRF, que não é necessária para APIs stateless.
                .csrf(csrf -> csrf.disable())
                // Configura a gestão de sessão para ser stateless (sem estado).
                // O servidor não guarda informações do usuário entre as requisições.
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Permite TODAS as requisições para QUALQUER endpoint.
                        .anyRequest().permitAll()
                        // Aqui o spring abre todas as portas para realizar qualquer requisição,
                        // pois nós já confirmamos que a geração de token já está funcionando
                );

        return http.build();
    }




}


