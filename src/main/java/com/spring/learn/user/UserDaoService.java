package com.spring.learn.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int userCount = 3;

	static {
		users.add(new User(1, "Venkat", new Date()));
		users.add(new User(2, "Chumma", new Date()));
		users.add(new User(3, "Durga", new Date()));

	}

	public List<User> findAllUsers() {
		return users;
	}

	public User createUser(User user) {
		if (user.getId() == 0) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOneUser(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User deleteUserById(int id) {
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id) {
				itr.remove();
			return user;
			}
		}
		return null;
	}

}
