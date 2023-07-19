package com.enos.techsolutio.controller;

import com.enos.techsolutio.model.Produto;
import com.enos.techsolutio.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl produtoService;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <List<Produto>> listaProdutos() {
        return ResponseEntity.ok().body(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <Produto> listaProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.listaProdutoPorId(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Produto> cadastraProduto(@Valid @RequestBody Produto produto){
        produtoService.salvarProduto(produto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Produto> alteraProduto(@Valid @RequestBody Produto produto, @PathVariable Long id){
        produtoService.alterarProduto(produto, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {

        produtoService.excluirProduto(id);

        return ResponseEntity.noContent().build();
    }

}
