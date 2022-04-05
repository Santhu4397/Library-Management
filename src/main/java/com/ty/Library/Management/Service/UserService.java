package com.ty.Library.Management.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Library.Management.dto.User;
import com.ty.Library.Management.util.ResponseStructure;


public interface UserService {


	public ResponseEntity<ResponseStructure<User>> saveUser(User user,int bookid);

	public ResponseEntity<ResponseStructure<List<User>>> getAll();

	public ResponseEntity<ResponseStructure<User>> getUserById(int id);

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user,int bookid);

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id);

	ResponseEntity<ResponseStructure<User>> updateUser2(int id, User user, int bookid);
}
