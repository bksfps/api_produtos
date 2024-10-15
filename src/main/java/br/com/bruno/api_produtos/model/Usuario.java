package br.com.bruno.api_produtos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "usuarios") // Define a coleção no MongoDB
public class Usuario {
    @Id
    private String id; // ID do usuário

    private String username; // Nome de usuário
    private String senha; // Senha
}
