package com.ty.Library.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.Library.Management.dto.Books;

public interface Libraryrepo extends JpaRepository<Books, Integer>{

}
