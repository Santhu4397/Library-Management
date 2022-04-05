package com.ty.Library.Management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ty.Library.Management.dto.Books;

public interface Libraryrepo extends JpaRepository<Books, Integer>{
	@Query("select c from Books c where c.stock!=0")
	public List<Books> getallbooks();

}
