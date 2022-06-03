package com.generation.lojadegames.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.generation.lojadegames.model.Produto;

@Repository
public interface ProdutoRepository {
	
	public List<Produto> findAllByNomeContainingIgnoreCase (String nome);
	
}
