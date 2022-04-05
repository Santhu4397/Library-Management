package com.ty.Library.Management.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Library.Management.Dao.UserDao;
import com.ty.Library.Management.dto.User;
import com.ty.Library.Management.repository.Userrepo;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	Userrepo userrepo;

	@Override
	public User saveUser(List<User> users,int bookid) {
	User user=null;
		for(User u:users) {
		user=u;
		}
	
		return userrepo.save(user);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userrepo.getById(id);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User updateUser(int id, User user) {
		User exisiting = getUserById(id);
		if (exisiting != null) {
			exisiting.setName(user.getName());
			exisiting.setNo_borrowed_book(user.getNo_borrowed_book());
			exisiting.setNo_returned_book(user.getNo_returned_book());
			return userrepo.save(exisiting);
		}

		return null;

	}

	@Override
	public boolean deleteUser(int id) {
		User user = getUserById(id);
		if (user != null) {
			userrepo.delete(user);
			return true;
		}
		return false;
	}

}
