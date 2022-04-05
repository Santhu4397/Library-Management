package com.ty.Library.Management.Dao;

import java.util.List;

import com.ty.Library.Management.dto.Books;

public interface LibraryDao {
	public Books saveLibrary(List<Books> dbs);

	public Books getLibraryById(int id);

	public List<Books> getAllLibrary();

	public Books updateLibrary(int id, Books libraryDB);

	public boolean deleteLibrary(int id);

}
