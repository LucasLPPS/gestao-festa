package com.algaworks.gestaofesta.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

// -> Criando uma classe que representa cada convidado (obs: um repositório deverá ser criado 
//    para tratar do armazenamento dos dados)

@Entity // torna a nossa classe uma entidade de banco de dados
public class Convidado implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id // identificador da entidade (chave primária no banco de dados)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment") // gera o identificador
    private Long id;
    
    private String nome;
    private Integer quantidadeAcompanhantes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantidadeAcompanhantes() {
        return quantidadeAcompanhantes;
    }
    public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
        this.quantidadeAcompanhantes = quantidadeAcompanhantes;
    }
    
}
