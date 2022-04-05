package com.ty.Library.Management.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.Library.Management.Dao.LibraryDao;
import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.repository.Libraryrepo;

@Service
public class LibraryDaoImpl implements LibraryDao {

	@Autowired
	Libraryrepo repo;

	@Override
	public Books saveLibrary(List<Books> dbs) {
		Books libraryDB = null;
		for (Books db : dbs) {
			libraryDB = db;
		}
		return repo.save(libraryDB);
	}

	@Override
	public Books getLibraryById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Books> getAllLibrary() {
		// TODO Auto-generated method stub
		return repo.getallbooks();
	}

	@Override
	public Books updateLibrary(int id, Books libraryDB) {
		// TODO Auto-generated method stub
		Books books = getLibraryById(id);
		books.setAuthor(libraryDB.getAuthor());
		books.setBook_Name(libraryDB.getBook_Name());
		books.setStock(libraryDB.getStock());
		books.setUser(libraryDB.getUser());
		return	repo.save(books);
		 
	}

	@Override
	public boolean deleteLibrary(int id) {
		// TODO Auto-generated method stub
		Books books = getLibraryById(id);
		if (books != null) {
			repo.delete(books);
			return true;
		} else
			return false;
	}

}
