package com.ty.Library.Management.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Library.Management.Dao.LibraryDao;
import com.ty.Library.Management.Service.LibraryService;
import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.util.ResponseStructure;
@Service
public class LibraryServiceImpl implements LibraryService{
		
	@Autowired
	LibraryDao dao;
	@Override
	public ResponseEntity<ResponseStructure<Books>> saveLibrary(Books library) {
		List<Books> list=null;
		ResponseStructure<Books> structure = new ResponseStructure<Books>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		if(list==null) {
			list=new ArrayList<Books>();
		
			list.add(library);
		}
		structure.setData(dao.saveLibrary(list));
		ResponseEntity<ResponseStructure<Books>> responseEntity = new ResponseEntity<ResponseStructure<Books>>(
				structure, HttpStatus.OK);
		return responseEntity;
		
	}
	@Override
	public ResponseEntity<ResponseStructure<List<Books>>> getAll() {
		List<Books> books =dao.getAllLibrary();
		ResponseEntity<ResponseStructure<List<Books>>> responseEntity=null;
		ResponseStructure<List<Books>> Structure=new ResponseStructure<List<Books>>();
		if(books !=null) {
		
		Structure.setStatus(HttpStatus.OK.value());
		Structure.setMessage("sucess");
		Structure.setData(dao.getAllLibrary());
		responseEntity=new ResponseEntity<ResponseStructure<List<Books>>>(Structure, HttpStatus.OK);
			return responseEntity;
		}else {
			Structure.setStatus(HttpStatus.NOT_FOUND.value());
			Structure.setMessage("No Books found");
			Structure.setData(null);
			responseEntity=new ResponseEntity<ResponseStructure<List<Books>>>(Structure, HttpStatus.NOT_FOUND);
				return responseEntity;

		}
	}
	@Override
	public ResponseEntity<ResponseStructure<Books>> getLibraryById(int id) {
		ResponseStructure<Books> structure = new ResponseStructure<Books>() ;
		Books db=dao.getLibraryById(id);
		if(db !=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.getLibraryById(id));
			ResponseEntity<ResponseStructure<Books>> responseEntity = new ResponseEntity<ResponseStructure<Books>>(
					structure, HttpStatus.OK);
			return responseEntity;
		}
		else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Id NOt Found");
			structure.setData(null);
			ResponseEntity<ResponseStructure<Books>> responseEntity = new ResponseEntity<ResponseStructure<Books>>(
					structure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
			}
	@Override
	public ResponseEntity<ResponseStructure<Books>> updateLibrary(int id, Books library) {
		ResponseStructure<Books> structure = new ResponseStructure<Books>()  ;
		Books exisitinglib=dao.getLibraryById(id);
		if(exisitinglib !=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.updateLibrary(id,library));
			ResponseEntity<ResponseStructure<Books>> responseEntity = new ResponseEntity<ResponseStructure<Books>>(
					structure, HttpStatus.OK);
			return responseEntity;
		}
		else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Id NOt Found");
			structure.setData(null);
			ResponseEntity<ResponseStructure<Books>> responseEntity = new ResponseEntity<ResponseStructure<Books>>(
					structure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<String>> deleteLibrary(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>()  ;
		boolean userremoved=dao.deleteLibrary(id);
		if(userremoved ==true) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData("removed the book whose Id :"+id);
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					structure, HttpStatus.OK);
			return responseEntity;
		}
		else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("book Id NOt Found");
			structure.setData(null);
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					structure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}


}
