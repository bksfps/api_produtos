package br.com.bruno.api_produtos.service;

import br.com.bruno.api_produtos.model.Usuario;
import br.com.bruno.api_produtos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario); // Salva o usuário no banco de dados
    }

    public Usuario login(String username, String senha) {
        Usuario usuario = usuarioRepository.findByUsername(username); // Busca usuário pelo nome de usuário
        if (usuario != null && usuario.getSenha().equals(senha)) { // Verifica senha
            return usuario; // Retorna o usuário se a senha estiver correta
        }
        return null; // Retorna null se o usuário não for encontrado ou a senha estiver incorreta
    }

    public void deletarUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")); // Lança exceção se usuário não existir
        usuarioRepository.delete(usuario); // Remove o usuário
    }
}
