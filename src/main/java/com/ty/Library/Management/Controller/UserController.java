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

import com.ty.Library.Management.Service.UserService;
import com.ty.Library.Management.dto.User;
import com.ty.Library.Management.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	@Autowired
	UserService service;
	

	@PostMapping("User/BookID/{bookid}")
	@ApiOperation("To save User")
	@ApiResponses({ @ApiResponse(code = 200, message = "user saved"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<User>> save(@RequestBody User user,@PathVariable int bookid) {
		System.out.println(user+"hdgfhgshdj"+bookid);
		return service.saveUser(user,bookid);
	}

	@GetMapping("User")
	@ApiOperation("To Get all the User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Found"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<User>>> get() {

		return service.getAll();
	}

	@PutMapping("User")
	@ApiOperation("To update the User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<User>> update(@RequestParam int id, @RequestBody  User user ) {
		return service.updateUser(id, user);

	}

	@GetMapping("User/{UserId}")
	@ApiOperation("To Get User by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "User found by id"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable("UserId") int id) {
		return service.getUserById(id);
	}

	@DeleteMapping("User")
	@ApiOperation("To delete the User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User deleted"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	@GetMapping("")
	public User getm() {
		return new User();
		
	}
}
