package com.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int userCounters = 3;
	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCounters);
		}
		users.add(user);
		return user;
	}

	public User FindOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;

	}
	public User deleteById(int id) {
		Iterator<User> iterator=users.iterator();
		while (iterator.hasNext()) {
			User user=iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;

	}

}
