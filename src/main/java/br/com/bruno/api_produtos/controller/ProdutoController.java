package br.com.bruno.api_produtos.controller;

import br.com.bruno.api_produtos.model.Produto;
import br.com.bruno.api_produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @PutMapping("/remover/{id}")
    public void removerQuantidade(@PathVariable String id, @RequestParam int quantidade) {
        produtoService.removerQuantidade(id, quantidade);
    }

    @PutMapping("/incrementar/{id}")
    public void incrementarEstoque(@PathVariable String id, @RequestParam int quantidade) {
        produtoService.incrementarEstoque(id, quantidade);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable String id) {
        produtoService.deletarProduto(id);
    }

    @PutMapping("/{id}/preco")
    public Produto atualizarPreco(@PathVariable String id, @RequestParam double novoPreco) {
        return produtoService.atualizarPreco(id, novoPreco);
    }

    // Outros métodos conforme necessário
}
