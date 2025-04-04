package com.springboot.practice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<UserDao> users = new ArrayList<UserDao> ();
	
	private static int usersCount = 0;
	
	static {
		users.add(new UserDao(++usersCount, "Ram", LocalDate.now().minusYears(30)));
		users.add(new UserDao(++usersCount, "Shyam", LocalDate.now().minusYears(27)));
		users.add(new UserDao(++usersCount, "Rohan", LocalDate.now().minusYears(32)));
	}
	
	public List<UserDao> retrieveAllUser() {
		return users;
	}
	
	public UserDao getUserById(int id) {
		Predicate<? super UserDao> predicate = user-> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void saveUser(UserDao user) {
		user.setId(++usersCount);
		users.add(user);
	}
	
	public void deleteUserById(int id) {
		Predicate<? super UserDao> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
