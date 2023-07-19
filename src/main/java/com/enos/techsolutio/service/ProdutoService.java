package com.enos.techsolutio.service;

import com.enos.techsolutio.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> listarProdutos();
    Produto listaProdutoPorId(Long id);
    Produto salvarProduto(Produto produto);
    Produto alterarProduto(Produto produto, Long id);
    void excluirProduto(Long id);

}
