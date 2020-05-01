package com.solucaomobile.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.solucaomobile.curso.domain.Cliente;
import com.solucaomobile.curso.dto.ClienteDTO;
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
	
	public Cliente update(Cliente obj) {
		Cliente  newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public void deleteById(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não e possivel excluir porque a entidade relacionada");
			
		}
		
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}

	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest PageRequest = org.springframework.data.domain.PageRequest.of (page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(PageRequest);
		
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getNome(),objDto.getEmail(),null, null);
		
		
	}

	private void updateData(Cliente newObj,Cliente obj) {
		
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
