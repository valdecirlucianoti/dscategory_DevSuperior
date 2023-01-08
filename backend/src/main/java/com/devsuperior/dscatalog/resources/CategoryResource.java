package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dscatalog.entities.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
// classes *resources são classes que implementam o controlador REST
//Esta class é um controlador REST
	
	
	//aqui eu programdo os endpoints
	@GetMapping //configura que esta classe sera um weebservice, que será um endpoin do recurso category é necessario a anotação GETMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = new ArrayList<>();
		
		list.add(new Category(1l, "books"));
		list.add(new Category(1l, "Electronics"));
		
		return ResponseEntity.ok().body(list);
	}
}
