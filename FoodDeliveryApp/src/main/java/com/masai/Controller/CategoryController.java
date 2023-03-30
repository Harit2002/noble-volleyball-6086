package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CategoryException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Category;
import com.masai.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("categories")
public class CategoryController {
	
	
	@Autowired
	CategoryService catserv;
	
	@PostMapping("")
	public ResponseEntity<Category> addingNewCategory(@Valid @RequestBody Category cat) throws RestaurantException, CategoryException{
	
		return new ResponseEntity<>(catserv.addCategory(cat), HttpStatus.CREATED);	
	
	}
	
	
	@PutMapping("")
	public ResponseEntity<Category> UpdateNewCategory(@Valid @RequestBody Category cat) throws CategoryException{
		
		
		return new ResponseEntity<>(catserv.updateCategory(cat), HttpStatus.ACCEPTED);
	}

	
	
	@DeleteMapping("/{catID}")
	public ResponseEntity<String> DeleteCategory(@PathVariable Integer catID) throws CategoryException{
		
		return new ResponseEntity<>(catserv.removeCategory(catID), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{catID}")
	public ResponseEntity<Category> ViewCateogory(@PathVariable Integer catID) throws CategoryException{
		
		return new ResponseEntity<>(catserv.viewCategory(catID), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Category>> ViewCateogoryAll() throws CategoryException{
		
		return new ResponseEntity<>(catserv.viewAllCategory(), HttpStatus.OK);
	}
	
	
	
	
}
