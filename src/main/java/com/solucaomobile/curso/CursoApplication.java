package com.solucaomobile.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solucaomobile.curso.domain.Categoria;
import com.solucaomobile.curso.domain.Cidade;
import com.solucaomobile.curso.domain.Estado;
import com.solucaomobile.curso.domain.Produto;
import com.solucaomobile.curso.repositories.CategoriaRepository;
import com.solucaomobile.curso.repositories.CidadeRepository;
import com.solucaomobile.curso.repositories.EstadoRepository;
import com.solucaomobile.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		Produto p1 = new Produto(null, "Computador", 2234.89);
		Produto p2 = new Produto(null, "Impressora",897.89);
		Produto p3 = new Produto(null, "mouse", 89.34);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
	    p3.getCategorias().addAll(Arrays.asList(cat1));
	    
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
			
		Estado est1 = new Estado(null, "Minas Gerais");
	    Estado est2 = new Estado(null, "São Paulo");
	    
	    Cidade c1 = new Cidade(null, "Uberlandia", est1);
	    Cidade c2 = new Cidade(null, "São Paulo", est2);
	    Cidade c3 = new Cidade(null, "Campinas", est2);
	    
	    est1.getCidades().addAll(Arrays.asList(c1));
	    est2.getCidades().addAll(Arrays.asList(c2, c3));
	    
	    estadoRepository.saveAll(Arrays.asList(est1, est2));
	    cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	
		
		
		
		
	}

}
