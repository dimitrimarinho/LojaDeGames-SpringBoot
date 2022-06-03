package com.generation.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojadegames.model.Categoria;
import com.generation.lojadegames.repository.CategoriaRepository;

//Indica que a classe é uma classe controladora da API (onde ficam os endpoints)
@RestController

//Cria um endpoint
@RequestMapping("/categorias")

//Permite que requisições de outras portas sejam aceitas na minha aplicação
@CrossOrigin("*")
public class CategoriaController {

	// Autowired funciona como injeção de dependência, transferindo a responsabilidade de manipular o banco de dados para o ProdutoRepository
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long id_categoria){
		return repository.findById(id_categoria)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/consoledogame/{console}")
	public ResponseEntity<List<Categoria>> GetByNome(@PathVariable String console){
		return ResponseEntity.ok(repository.findAllByConsoleContainingIgnoreCase(console));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> adicionaCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> alteraCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id_categoria}")
	public void deletaGame(@PathVariable long id_categoria) {
		repository.deleteById(id_categoria);
	}
	
}
