package com.enos.techsolutio.service.impl;

import com.enos.techsolutio.model.Produto;
import com.enos.techsolutio.respository.ProdutoRepository;
import com.enos.techsolutio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto listaProdutoPorId(Long id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        Produto produto1 = new Produto(produto.getNome(), produto.getFornecedor(), produto.getValor());
        produto1.setId(1l);
        return produtoRepository.save(produto1);
    }

    @Override
    public Produto alterarProduto(Produto produto, Long id) {

        Optional<Produto> buscaProduto = produtoRepository.findById(id);
        if(buscaProduto.isEmpty()){
            throw new RuntimeException("Produto não encontrado para edição!");
        }

        Produto produtoEncontrado = buscaProduto.get();
        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setFornecedor(produto.getFornecedor());
        produtoEncontrado.setValor(produto.getValor());

        return produtoRepository.save(produtoEncontrado);

    }

    @Override
    public void excluirProduto(Long id) {
        produtoRepository.delete(produtoRepository.findById(id).get());
    }
}
