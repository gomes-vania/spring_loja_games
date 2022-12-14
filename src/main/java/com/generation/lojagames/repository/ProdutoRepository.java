package com.generation.lojagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.lojagames.model.Produto;

//classe de ferramentas = que herda por meio da herança os métodos básicos
@Repository
public interface ProdutoRepository extends JpaRepository< Produto, Long> {

}
