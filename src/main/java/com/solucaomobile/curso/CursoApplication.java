package com.solucaomobile.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solucaomobile.curso.domain.Categoria;
import com.solucaomobile.curso.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriarepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		categoriarepository.saveAll(Arrays.asList(cat1,cat2));
		
	}

}
