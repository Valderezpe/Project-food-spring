package com.solucaomobile.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucaomobile.curso.domain.Categoria;
import com.solucaomobile.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {  
		Optional<Categoria> obj = repo.findById(id);  
		return obj.orElse(null);
		
	}

	public Categoria buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
