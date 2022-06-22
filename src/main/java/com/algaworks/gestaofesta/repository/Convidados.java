package com.algaworks.gestaofesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.gestaofesta.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {
    // -> interface chamada Convidados, que representa um repositório de convidados, 
    //    ou seja, um lugar onde podemos listar ou adicionar convidados.

    // -> interface JpaRepository, com isso podemos injetar um objeto do tipo Convidados 
    //    no controller, por exemplo.
}
