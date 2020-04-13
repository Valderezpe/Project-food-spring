package com.solucaomobile.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucaomobile.curso.domain.Cliente;
import com.solucaomobile.curso.repositories.ClienteRepository;
import com.solucaomobile.curso.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {  
		Optional<Cliente> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName())); 
	}

	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
