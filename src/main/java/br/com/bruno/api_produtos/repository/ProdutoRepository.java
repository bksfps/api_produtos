package br.com.bruno.api_produtos.repository;

import br.com.bruno.api_produtos.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    Produto findByNome(String nome);
}