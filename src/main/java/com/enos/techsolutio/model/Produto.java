package com.enos.techsolutio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Produto {

    public Produto(String nome, String fornecedor, BigDecimal valor){
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.valor = valor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "Fornecedor obrigatório")
    private String fornecedor;

    @NotNull(message = "Valor obrigatório")
    private BigDecimal valor;
}
