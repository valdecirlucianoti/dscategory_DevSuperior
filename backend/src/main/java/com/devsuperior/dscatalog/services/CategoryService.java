package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exception.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> categoryList = repository.findAll();
		
		//Esta unica linha de código simplifica todo o for que ocorre nas linhas abaixo
		return categoryList.stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
		
		/*
		List<CategoryDTO> listDTO = new ArrayList<>();
		for (Category category : list) {listDTO.add(new CategoryDTO(category));}return listDTO;
		*/
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> optional = repository.findById(id); 
		Category category = optional.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new CategoryDTO(category);
	}
}
