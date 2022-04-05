package com.ty.Library.Management.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.util.ResponseStructure;

public interface LibraryService {
	public ResponseEntity<ResponseStructure<Books>> saveLibrary(Books library);

	public ResponseEntity<ResponseStructure<List<Books>>> getAll();

	public ResponseEntity<ResponseStructure<Books>> getLibraryById(int id);

	public ResponseEntity<ResponseStructure<Books>> updateLibrary(int id, Books library);

	public ResponseEntity<ResponseStructure<String>> deleteLibrary(int id);

}
