package com.generation.lojadegames.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.generation.lojadegames.model.Categoria;

@Repository
public interface CategoriaRepository {
	
	public List<Categoria> findAllByConsoleContainingIgnoreCase(String console);

}
