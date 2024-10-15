package br.com.bruno.api_produtos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "produtos") // Define a coleção no MongoDB
public class Produto {
    @Id
    private String id; // Mude o tipo para String para o ID do MongoDB

    private String nome;
    private double preco;
    private int quantidadeEmEstoque = 1;
    private String imagemUrl;
}