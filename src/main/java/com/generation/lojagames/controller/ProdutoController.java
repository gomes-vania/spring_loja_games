package com.generation.lojagames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
		//usar a interface e para isso criamos uma injeção de dependência
		//através 
		@Autowired 
		private ProdutoRepository produtoRepository;
		
		@GetMapping("/listagemDeProdutos")
		public ResponseEntity<List<Produto>> getAll(){
			return ResponseEntity.ok(produtoRepository.findAll());
			/* select * from tb_produto */
		}
		
		//configuração de variável de caminho
		//PathVariable pegará a variável {id} e armazenará em id do tipo da classe Long
		@GetMapping("/{id}")
		public ResponseEntity<Produto> getById(@PathVariable Long id){
			/*
			Optional<Produto> buscarProduto= produtoRepository.findById(id);
			
			if(buscarProduto.isPresent())
				return ResponseEntity.ok(buscarProduto.get());
			else
				return ResponseEntity.notFound().build();
			*/
			
			return produtoRepository.findById(id)
					//lambidas
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
		
		/* select from tb_produto where id = 1; */
		}
		
}
