package com.ty.Library.Management.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ty.Library.Management.dto.User;

public interface UserDao {

	public User saveUser(List<User> user,int bookid);

	public User getUserById(int id);

	public List<User> getAllUser();

	public User updateUser(int id, List<User> user);

	public boolean deleteUser(int id);

	User updateUser2(User user);

	User saveUser1(User user);

}
