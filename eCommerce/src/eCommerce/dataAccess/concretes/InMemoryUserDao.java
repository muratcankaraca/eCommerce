package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	private List<User> users = new ArrayList<User>();
	
	
	public InMemoryUserDao() {
		
		User user1 =new User(1,"Murat","Karaca","murat@gmail.com","342423432",true);
		User user2 =new User(2,"CAN","Kaya","murat1@gmail.com","3666666",true);
		User user3 =new User(3,"ALÝ","Kara","murat2@gmail.com","5435432",true);
		
		users.add(user1);
		users.add(user2);
		users.add(user1);
	}

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý eklendi " + user.getFirstName());
		users.add(user);
	}

	@Override
	public void delete(User user) {
		int userId = 0;
		User userToDelete=users.stream()
				.filter(u->u.getId()==userId)
				.findFirst()
				.orElse(null);
		users.remove(userToDelete);
	}

	@Override
	public void update(User user) {
		User userUpdate=users.stream()
				.filter(u->u.getId()==user.getId())
				.findFirst()
				.orElse(null);
		
		userUpdate.setEmail(user.getEmail());
		userUpdate.setFirstName(user.getFirstName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setVerify(user.isVerify());
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User get(String email) {
		User user=users.stream()
				.filter(u->u.getEmail()==email)
				.findFirst()
				.orElse(null);
		return user;
	}

}
