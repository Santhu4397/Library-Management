package com.ty.Library.Management.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Library.Management.Dao.LibraryDao;
import com.ty.Library.Management.Dao.UserDao;
import com.ty.Library.Management.Service.UserService;
import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.dto.User;
import com.ty.Library.Management.repository.Libraryrepo;
import com.ty.Library.Management.util.ResponseStructure;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserDao dao;
	@Autowired
	LibraryDao libraryDao;

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user, int bookid) {
		List<User> users = null;
		List<Books> books = null;
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		if (users == null) {
			users = new ArrayList<User>();
			Books book = libraryDao.getLibraryById(bookid);
			if (books == null && book != null) {
				books = new ArrayList<Books>();
				books.add(book);
				user.setLibraryDB(books);
				users.add(user);
				book.setUser(users);
			}
		}
		structure.setData(dao.saveUser(users, bookid));
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(structure,
				HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<User>>> getAll() {
		ResponseStructure<List<User>> Structure = new ResponseStructure<List<User>>();
		Structure.setStatus(HttpStatus.OK.value());
		Structure.setMessage("sucess");
		Structure.setData(dao.getAllUser());
		ResponseEntity<ResponseStructure<List<User>>> responseEntity = new ResponseEntity<ResponseStructure<List<User>>>(
				Structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {

		ResponseStructure<User> structure = new ResponseStructure<User>();
		User user = dao.getUserById(id);
		if (user != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.getUserById(id));
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					structure, HttpStatus.OK);

			System.out.println(id + " kt " + structure);
			return responseEntity;
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Id NOt Found");
			structure.setData(null);
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					structure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user,int bookid) {
		List<User> users = null;
		List<Books> books = null;
		ResponseStructure<User> structure = new ResponseStructure<User>();
		User exisitinguser = dao.getUserById(id);
		if (exisitinguser != null) {
			System.out.println(structure);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			if (users == null) {
				users = new ArrayList<User>();
				Books book = libraryDao.getLibraryById(bookid);
				if (books == null && book != null) {
					books = new ArrayList<Books>();
					books.add(book);
					user.setLibraryDB(books);
					users.add(user);
					book.setUser(users);
				}
			}
			structure.setData(dao.updateUser(id, users));
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					structure, HttpStatus.OK);
			return responseEntity;
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Id NOt Found");
			structure.setData(null);
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					structure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	@Autowired
	Libraryrepo libraryrepo;
	
	@Override
	public ResponseEntity<ResponseStructure<User>> updateUser2(int id, User user,int bookid) {
		User user2 = dao.getUserById(id);
		if(user2!=null) {
			Books books = libraryDao.getLibraryById(bookid);
			List<Books> books2 = user2.getLibraryDB();
			books2.add(books);
			user2.setLibraryDB(books2);
			List<User> users = books.getUser();
			for (User user3 : users) {
				user3.getLibraryDB().add(books);
				dao.updateUser2(user3);
				
			}
			
		}
		
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		structure.setData(dao.updateUser2(user2));
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				structure, HttpStatus.OK);
		List<Books> books = user2.getLibraryDB();
		for (Books books2 : books) {
			System.out.println(books2.getBook_Name()+"        ===========================================");
			
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		boolean userremoved = dao.deleteUser(id);
		if (userremoved == true) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData("removed the user whose Id :" + id);
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					structure, HttpStatus.OK);
			return responseEntity;
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Id NOt Found");
			structure.setData(null);
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					structure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

}
