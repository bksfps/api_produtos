package br.com.bruno.api_produtos.controller;

import br.com.bruno.api_produtos.model.Usuario;
import br.com.bruno.api_produtos.service.UsuarioService;
import br.com.bruno.api_produtos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario); // Cadastra um novo usuário
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario.getUsername(), usuario.getSenha()); // Realiza login do usuário
    }

    @DeleteMapping("/{id}") // Adicionando a rota para remover um usuário
    public ResponseEntity<String> remover(@PathVariable String id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
