package br.com.bruno.api_produtos.repository;

import br.com.bruno.api_produtos.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByUsername(String username); // Método para encontrar usuário pelo nome de usuário
}
