package com.ty.Library.Management.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Library.Management.Dao.UserDao;
import com.ty.Library.Management.dto.Books;
import com.ty.Library.Management.dto.User;
import com.ty.Library.Management.repository.Libraryrepo;
import com.ty.Library.Management.repository.Userrepo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	Userrepo userrepo;

	@Autowired
	Libraryrepo libraryrepo;

	@Override
	public User saveUser(List<User> users, int bookid) {
		User user = null;
		for (User u : users) {
			user = u;
		}

		return userrepo.save(user);
	}

	@Override
	public User saveUser1(User user) {

		return userrepo.save(user);
	}

	@Override
	public User getUserById(int id) {

		return userrepo.getById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userrepo.findAll();
	}

	@Override
	public User updateUser(int id, List<User> users) {
		User user = null;
		for (User u : users) {
			user = u;
		}
		User exisiting = getUserById(id);
		if (exisiting != null) {
			exisiting.setName(user.getName());
			exisiting.setNo_borrowed_book(user.getNo_borrowed_book());
			exisiting.setNo_returned_book(user.getNo_returned_book());
			exisiting.setBorrowed_Date(user.getBorrowed_Date());
			exisiting.setReturned_Date(user.getReturned_Date());
			return userrepo.save(exisiting);
		}

		return null;

	}

	@Override
	public User updateUser2(User user) {
		List<Books> books = user.getLibraryDB();
		for (Books books2 : books) {
			List<User> users = books2.getUser();
			users.add(user);
			books2.setUser(users);
			libraryrepo.save(books2);
		}

		return userrepo.save(user);

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
