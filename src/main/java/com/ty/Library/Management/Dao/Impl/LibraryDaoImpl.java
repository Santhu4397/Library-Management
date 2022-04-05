package com.ty.Library.Management.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.Library.Management.Dao.LibraryDao;
import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.repository.Libraryrepo;
@Service
public class LibraryDaoImpl implements LibraryDao{
	
		@Autowired
		Libraryrepo repo;
	@Override
	public Books saveLibrary(List<Books> dbs) {
		Books libraryDB = null;
		for(Books db:dbs) {
			libraryDB=db;
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
		return repo.findAll();
	}

	@Override
	public Books updateLibrary(int id, Books libraryDB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLibrary(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
