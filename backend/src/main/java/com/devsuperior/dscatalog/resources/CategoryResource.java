package com.devsuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
// classes *resources são classes que implementam o controlador REST
//Esta class é um controlador REST
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	//aqui eu programdo os endpoints
	//configura que esta classe sera um weebservice, que será um endpoin do recurso category é necessario a anotação GETMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
}
