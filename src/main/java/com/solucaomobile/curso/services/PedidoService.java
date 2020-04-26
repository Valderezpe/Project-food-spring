package com.solucaomobile.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucaomobile.curso.domain.Pedido;
import com.solucaomobile.curso.repositories.PedidoRepository;
import com.solucaomobile.curso.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {  
		Optional<Pedido> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Pedido.class.getName())); 
	}

	public Pedido buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
