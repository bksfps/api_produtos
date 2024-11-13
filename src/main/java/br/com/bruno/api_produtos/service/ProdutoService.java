package br.com.bruno.api_produtos.service;

import br.com.bruno.api_produtos.model.Produto;
import br.com.bruno.api_produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        Produto produtoExistente = produtoRepository.findByNome(produto.getNome());
        if (produtoExistente != null) {
            produtoExistente.setQuantidadeEmEstoque(
                    produtoExistente.getQuantidadeEmEstoque() + produto.getQuantidadeEmEstoque()
            );
            return produtoRepository.save(produtoExistente);
        } else {
            return produtoRepository.save(produto);
        }
    }



    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public void removerQuantidade(String id, int quantidade) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        if (produto.getQuantidadeEmEstoque() < quantidade) {
            throw new RuntimeException("Quantidade em estoque insuficiente");
        }
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
        produtoRepository.save(produto);
    }

    public void incrementarEstoque(String id, int quantidade) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + quantidade);
        produtoRepository.save(produto);
    }

    public void deletarProduto(String id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }

    public Produto atualizarPreco(String id, double novoPreco) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setPreco(novoPreco);
        return produtoRepository.save(produto);
    }

    public Produto atualizarCategoria(String id, String novaCategoria) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setCategoria(novaCategoria);
        return produtoRepository.save(produto);
    }

    public Produto atualizarDescricao(String id, String novaDescricao) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setDescricao(novaDescricao); // Atualiza a descrição
        return produtoRepository.save(produto); // Salva o produto atualizado
    }

}
