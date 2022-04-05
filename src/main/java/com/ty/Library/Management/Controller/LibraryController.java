package com.ty.Library.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Library.Management.Service.LibraryService;
import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.dto.User;
import com.ty.Library.Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LibraryController {
	@Autowired
	LibraryService service;
	@PostMapping("books")
	public ResponseEntity<ResponseStructure<Books>> saveBooks(@RequestBody  Books book){
		return service.saveLibrary(book);
	}

	@PostMapping("book")
	@ApiOperation("To save User") 
	@ApiResponses({ @ApiResponse(code = 200, message = "user saved"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Books>> save(@RequestBody Books book) {
		
		return service.saveLibrary(book);
	}

	@GetMapping("book")
	@ApiOperation("To Get all the User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Books>>> get() {

		return service.getAll();
	}

	@PutMapping("book")
	@ApiOperation("To update the User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Books>> update(@RequestParam int id, @RequestBody  Books book ) {
		return service.updateLibrary(id, book);

	}

	@GetMapping("book/{UserId}")
	@ApiOperation("To Get User by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "User found by id"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Books>> getUserById(@PathVariable("UserId") int id) {
		return service.getLibraryById(id);
	}

	@DeleteMapping("book")
	@ApiOperation("To delete the User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id) {
		return service.deleteLibrary(id);
	}
	
}
