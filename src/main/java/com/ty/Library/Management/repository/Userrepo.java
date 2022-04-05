package com.ty.Library.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.Library.Management.dto.User;

public interface Userrepo extends JpaRepository<User, Integer>{


}
